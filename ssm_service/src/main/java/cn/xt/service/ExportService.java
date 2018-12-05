package cn.xt.service;

import cn.xt.dao.*;
import cn.xt.domain.*;
import cn.xt.utils.UtilFuns;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@WebService
public class ExportService {
    @Autowired
    private ExportMapper exportMapper;
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private ExportProductMapper exportProductMapper;
    @Autowired
    private ExtEproductMapper extEproductMapper;

    @WebMethod(exclude = true)
    public void setExportMapper(ExportMapper exportMapper) {
        this.exportMapper = exportMapper;
    }

    /**
     * 查询所有报运单
     * @return
     */
    @WebMethod(exclude = true)
   public List<Export> findList(){
       return exportMapper.find();
   }

    /**
     * 查询购销合同，已上报的
     * @return
     */
    @WebMethod(exclude = true)
    public List<Contract> getContractInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("state",1);
       return contractMapper.find(map);
    }

    /**
     * 添加报运
     * @return
     */
    @WebMethod(exclude = true)
    public void add(Export export,String[] ids) {
        //生成UUID,再替换
       String s = UUID.randomUUID().toString();
        s = s.replace("-","");
        //报运单id
        export.setExportId(s);

        //制单日期  为当前日期
        export.setInputDate(new Date());

        //1.根据合同ID获得合同对象，获取合同号
        //2.将合同下的货物信息搬家到报运下货物表中
        //3.将合同下的附件信息搬家到报运下的附件中
        //合同id放进ids字段中
        export.setContractIds(UtilFuns.joinStr(ids,","));//添加报运单  工具类拼串

        String contractNos = "";
        for(int i = 0 ; i < ids.length ; i++){
            //得到合同对象
            Contract contract = contractMapper.view(ids[i]);
            contractNos += contract.getContractNo() + " "; //以空格作为分隔符
        }

        //去掉最后的字符
        contractNos = UtilFuns.delLastChar(contractNos);

        //合同号
        export.setCustomerContract(contractNos);
        //状态 默认为0 草稿
        export.setState(0);

        //保存报运单
        exportMapper.insertSelective(export);

        //处理货物信息
        for(int i = 0; i < ids.length; i++){

            //得到合同对象
            Contract contract = contractMapper.view(ids[i]);
            for( ContractProduct  contractProduct : contract.getContractProducts()){

                ExportProduct ep = new ExportProduct();
                String uuid = UUID.randomUUID().toString();
                uuid = uuid.replace("-","");
                ep.setExportProductId(uuid); //主键  UUID生成
                ep.setExportId(export.getExportId()); //设置外键

                //数据搬家，将合同下的货物信息写到报运货物信息中
                ep.setFactoryId(contractProduct.getFactory().getFactoryId()); //厂家id
                ep.setFactoryName(contractProduct.getFactory().getFactoryName());//厂家名称
                ep.setProductNo(contractProduct.getProductNo());//货号
                ep.setPackingUnit(contractProduct.getPackingUnit());//包装
                ep.setCnumber(contractProduct.getCnumber());//数量
                ep.setBoxNum(contractProduct.getBoxNum());
                ep.setPrice(contractProduct.getPrice());//单价

                //保存报运单下的货物
                exportProductMapper.insertSelective(ep);

                //处理附件信息
                for(ExtCproduct extC : contractProduct.getExtCproducts()){
                    //实例化报运单下的附件对象
                    ExtEproduct extE = new ExtEproduct();

                    //copy属性
                    BeanUtils.copyProperties(extC,extE); //拷贝  工具类
                    String uuid2 = UUID.randomUUID().toString();
                    uuid2 = uuid2.replace("-","");
                    extE.setExtEproductId(uuid2); //附件ID
                    extE.setExportProductId(ep.getExportProductId());//绑定外键

                    extE.setFactoryId(extC.getFactory().getFactoryId());//厂家id
                    extE.setFactoryName(extC.getFactory().getFactoryName());//厂家名称

                    //保存附件
                    extEproductMapper.insertSelective(extE);
                }
            }
        }
    }

    /**
     * 根据id查询,回显
     * @return
     */
    public Export get(String exportId){
        return exportMapper.selectByPrimaryKey(exportId);
    }

    /**
     * 修改加货物批量修改
     * @return
     */
    @WebMethod(exclude = true)
    public void upadte(Export export,
                      String[] mr_id,
                      Integer[] mr_orderNo,
                      Integer[] mr_cnumber,
                      Double[] mr_grossWeight,
                      Double[] mr_netWeight,
                      Double[] mr_sizeLength,
                      Double[] mr_sizeWidth,
                      Double[] mr_sizeHeight,
                      Double[] mr_exPrice,
                      Double[] mr_tax){
        //修改报运单
        exportMapper.updateByPrimaryKeySelective(export);

        //循环mr_id
        for(int i = 0; i < mr_id.length ;i++){
            //根据id查询exportProduct对象
            ExportProduct exportProduct = exportProductMapper.selectByPrimaryKey(mr_id[i]);
            //赋值
            exportProduct.setOrderNo(mr_orderNo[i]);
            exportProduct.setCnumber(mr_cnumber[i]);
            exportProduct.setGrossWeight(mr_grossWeight[i]);
            exportProduct.setNetWeight(mr_netWeight[i]);
            exportProduct.setSizeLength(mr_sizeLength[i]);
            exportProduct.setSizeWidth(mr_sizeWidth[i]);
            exportProduct.setSizeHeight(mr_sizeHeight[i]);
            exportProduct.setExPrice(mr_exPrice[i]);
            exportProduct.setTax(mr_tax[i]);

            //更新
            exportProductMapper.updateByPrimaryKeySelective(exportProduct);
        }

    }

    /**
     * 得到报运下的货物信息
     * 拼串 JS
     * addTRRecord(objId, id, productNo, cnumber, grossWeight, netWeight, sizeLength, sizeWidth, sizeHeight, exPrice, tax)
     * @return
     */
    @WebMethod(exclude = true)
    public String getMrecordData(String exportId){
        ExportProductExample example = new ExportProductExample();
        ExportProductExample.Criteria criteria = example.createCriteria();
        criteria.andExportIdEqualTo(exportId);
        List<ExportProduct> list = exportProductMapper.selectByExample(example);

        StringBuffer buffer = new StringBuffer();
        for (ExportProduct exportProduct : list) {
        //拼接 双引号转义
        buffer.append("addTRRecord(\"mRecordTable\", \"").append(exportProduct.getExportProductId()).append("\",\"").append(exportProduct.getProductNo()).append("\", \"").append(exportProduct.getCnumber()).append("\", \"").append(UtilFuns.convertNull(exportProduct.getGrossWeight())).append("\", \"").append(UtilFuns.convertNull(exportProduct.getNetWeight())).append("\", \"").append(UtilFuns.convertNull(exportProduct.getSizeLength())).append("\", \"").append(UtilFuns.convertNull(exportProduct.getSizeWidth())).append("\", \"").append(UtilFuns.convertNull(exportProduct.getSizeHeight())).append("\", \"").append(UtilFuns.convertNull(exportProduct.getExPrice())).append("\", \"").append(UtilFuns.convertNull(exportProduct.getTax())).append("\");");
        }
        return buffer.toString();
    }

    /**
     * 删除单个，级联
     * @param exportId
     */
    @WebMethod(exclude = true)
    public void delete(String[] exportId) {
        List<String> list = new ArrayList<>();
        for (String id : exportId) {
            //删除当前报运下的货物附件
            extEproductMapper.deleteByExportProductId(id);
        }

        for (String id : exportId) {
            //删除当前报运下的货物
            exportProductMapper.deleteByExportId(id);
        }

        for(String id : exportId){
            list.add(id);
        }
        //删除报运单
        ExportExample example = new ExportExample();
        ExportExample.Criteria criteria = example.createCriteria();
        criteria.andExportIdIn(list);
        exportMapper.deleteByExample(example);
    }

    /**
     * 修改状态
     * @return
     */
    public int updateState(Map<String,Object> map){
        return exportMapper.updateState(map);
    }
}




















