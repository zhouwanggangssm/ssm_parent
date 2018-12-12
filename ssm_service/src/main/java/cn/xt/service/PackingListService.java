package cn.xt.service;

import cn.xt.dao.*;
import cn.xt.domain.Export;
import cn.xt.domain.PackingList;
import cn.xt.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 装箱业务层
 */
@Service
public class PackingListService {
    @Autowired
   private PackingListMapper packingListMapper;
    @Autowired
    private ExportMapper exportMapper;
    @Autowired
    private ShippingOrderMapper shippingOrderMapper;//委托
    @Autowired
    private InvoiceMapper invoiceMapper;//发票
    @Autowired
    private FinanceMapper financeMapper;//财务
    /**
     * 查询所有装箱单
     * @return
     */
    public List<PackingList> findPage(){
        return packingListMapper.selectByExample(null);
    }

    /**
     * 新增
     * 拼接片段HTML
     * @return
     */
    public String getDivDataCreate(String[] exportIds){
        //创建StringBuffer对象
        StringBuffer buffer = new StringBuffer();
        //循坏
        for (int i = 0; i<exportIds.length; i++) {
            Export export = exportMapper.selectByPrimaryKey(exportIds[i]);
            buffer.append("<input type=\"checkbox\" name=\"exportIds\" checked value=\"").append(exportIds[i]).append("|").append(export.getCustomerContract()).append("\" class=\"input\"/>");
            buffer.append(export.getCustomerContract()).append("&nbsp;&nbsp;");//得到报运下的合同及确认书号
        }
        return buffer.toString();
    }

    /**
     * 修改
     * 拼接片段HTML
     * @return
     */
    public String getDivDataUpdate(String[] exportIds,String[] exportNos){
        //创建StringBuffer对象
        StringBuffer buffer = new StringBuffer();
        //循坏
        for (int i = 0; i<exportIds.length; i++) {
            buffer.append("<input type=\"checkbox\" name=\"exportIds\" checked value=\"").append(exportIds[i]).append("|").append(exportNos[i]).append("\" class=\"input\"/>");
            buffer.append(exportNos[i]).append("&nbsp;&nbsp;");//得到报运下的合同及确认书号
        }
        return buffer.toString();
    }


    /**
     * 新增
     * @param packingList
     */
    public void insert(PackingList packingList) {
        //调用方法
        this.spellString(packingList);

        //生成UUID
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        //装箱ID
        packingList.setPackingListId(uuid);
        //状态 默认为0
        packingList.setState(0);

        //调用新增的方法
        packingListMapper.insertSelective(packingList);
    }

    /**
     * 根据id查询
     * @param packingListId
     */
    public PackingList get(String packingListId) {
        return packingListMapper.selectByPrimaryKey(packingListId);
    }

    /**
     * 修改
     * @param packingList
     */
    public void update(PackingList packingList) {
        //调用方法
        this.spellString(packingList);

        //修改
        packingListMapper.updateByPrimaryKeySelective(packingList);
    }

    /**
     * 拆串，拼串
     * @param packingList
     * @return
     */
    private PackingList spellString(PackingList packingList){
        String exportIds = "";
        String exportNos = "";
        //得到getExportIds 用逗号分割
        String[] _s = packingList.getExportIds().split(",");
        //循坏
        for (int i = 0; i < _s.length; i++){
            //创建String数组用“|”分割
            String[] _tmp = _s[i].split("\\|");
            exportIds += _tmp[0] + "|";
            exportNos += _tmp[1] + "|";
        }
        //用工具类去掉最后一个 |
        exportIds = UtilFuns.delLastChar(exportIds);
        exportNos = UtilFuns.delLastChar(exportNos);
        //封装数据
        packingList.setExportIds(exportIds);
        packingList.setExportNos(exportNos);

        return packingList; //返回
    }

    /**拼接HTML片段
     *
     *
     * @return
     */
    public String getDivDataView(String[]exportNos){
        //创建StringBuffer对象
        StringBuffer buffer = new StringBuffer();
        //循坏
        for (int i = 0; i<exportNos.length; i++) {
            buffer.append(exportNos[i]).append("&nbsp;&nbsp;");//得到报运下的合同及确认书号
        }
        return buffer.toString();
    }

    /**
     * 删除
     * @param packingListId
     */
    public void delete(String packingListId) {
        //委托删除
        shippingOrderMapper.deleteByPrimaryKey(packingListId);
        //发票删除
        invoiceMapper.deleteByPrimaryKey(packingListId);
        //财务删除
        financeMapper.deleteByPrimaryKey(packingListId);
        //删除装箱单
        packingListMapper.deleteByPrimaryKey(packingListId);
    }

    /**
     * 修改状态
     * @param map
     * @return
     */
    public int updateState(Map<String,Object> map){
        return packingListMapper.updateState(map);
    }
}
