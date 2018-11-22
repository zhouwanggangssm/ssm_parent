package cn.xt.service;

import cn.xt.dao.ContractMapper;
import cn.xt.dao.ContractProductMapper;
import cn.xt.dao.ExtCproductMapper;
import cn.xt.dao.FactoryMapper;
import cn.xt.domain.*;
import cn.xt.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class ContractProductService {
    @Autowired
    private ContractProductMapper contractProductMapper;
    @Autowired
    private FactoryMapper factoryMapper;
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private ExtCproductMapper extCproductMapper;
    /**
     * 查询厂家名称列表
     * @param ctype
     * @param state
     * @return
     */
    public List<Factory> factoryList(String ctype,String state){
        return factoryMapper.selectByExamplewithf(ctype,state);
    }

    /**
     * 查询厂家信息，附件信息
     * @return
     */
    public List<ContractProduct> queryListAll(String contractId){
        List<ContractProduct> list = contractProductMapper.selectByExamplewithcp(contractId);
        if (list==null||list.size()==0) {
            list = new ArrayList<>();
            ContractProduct contractProduct = new ContractProduct();
            contractProduct.setContractId(contractId);
            list.add(contractProduct);
        }
        return list;
    }

    /**
     * 添加货物
     */
    public void add(ContractProduct contractProduct){
        //获取id
        contractProduct.setContractId(contractProduct.getContractId().split(",")[0]);

        //定义double类型的变量
        double amount = 0d;

        //随机生成UUID
        String uuid = UUID.randomUUID().toString();
        //把"-" 替换成""
        uuid = uuid.replace("-","");

        //货物id
        contractProduct.setContractProductId(uuid);
        if(UtilFuns.isNotEmpty(contractProduct.getPrice()) && UtilFuns.isNotEmpty(contractProduct.getCnumber())){
            amount=contractProduct.getPrice()*contractProduct.getCnumber(); //货物总金额
            contractProduct.setAmount(amount);//把总金额放进实体
        }
        contractProductMapper.insertSelective(contractProduct);
        //修改购销合同的总金额
        Contract contract = getContractById(contractProduct.getContractId());
        //如果购销合同总金额不等于0
        if (contract.getTotalAmount() != 0) {
            //购销合同金额加货物金额
            contract.setTotalAmount(contract.getTotalAmount()+contractProduct.getAmount());
        }else{
            //否则直接把查出来的金额赋值
            contract.setTotalAmount(contractProduct.getAmount());
        }
        //调用修改方法
        updateAmount(contract);

    }

    /**
     * 修改货物
     * @param contractProduct
     */
    public void update(ContractProduct contractProduct){
        contractProductMapper.updateByPrimaryKeySelective(contractProduct);
    }

    /**
     * 删除货物和附件
     * @param contractProduct
     */
    public void delete(ContractProduct contractProduct) throws Exception {
        //加载要删除的货物对象
        ContractProduct contractProduct1 = contractProductMapper.selectByPrimaryKeywithExport(contractProduct.getContractProductId());

        //得到货物下面的附件列表
        Set<ExtCproduct> extCproducts = contractProduct1.getExtCproducts();

        //加载购销合同对象
        Contract contract = contractMapper.selectByPrimaryKey(contractProduct.getContractId());

        for (ExtCproduct extCproduct : extCproducts) {
            contract.setTotalAmount(contract.getTotalAmount()-extCproduct.getAmount());
        }

        contract.setTotalAmount(contract.getTotalAmount()-contractProduct1.getAmount());

        //更新购销合同
        contractMapper.updateByPrimaryKeySelective(contract);

        //删除附件信息
        deleteExtCproductKeys(contractProduct.getContractProductId());

            //删除
        contractProductMapper.deleteByPrimaryKey(contractProduct.getContractProductId());

    }

    /**
     * 删除附件信息
     * @return
     */
    private int deleteExtCproductKeys(String contractProductId){
        ExtCproductExample example = new ExtCproductExample();
        ExtCproductExample.Criteria criteria = example.createCriteria();
        //调用andContractProductIdEqualTo方法
        criteria.andContractProductIdEqualTo(contractProductId);
        return extCproductMapper.deleteByExample(example);
    }

    /**
     * 根据id查询附件信息
     * @return
     */
    private ContractProduct getContractProductAndEById(String contractProductId){
       return contractProductMapper.selectByPrimaryKeywithcp(contractProductId);
    }

    /**
     * 根据contractProductId查询对象
     * @return
     */
    public ContractProduct  getContractProductById(String contractProductId){
       return contractProductMapper.selectByPrimaryKey(contractProductId);
    }

    /**
     * 根据contractId得到Contract对象,购销合同
     * @param contractId
     * @return
     */
    private Contract getContractById(String contractId){
        return contractMapper.selectByPrimaryKey(contractId);
    }

    /**
     * 根据contract修改主表购销合同的总金额
     * @param contract
     * @return
     */
    private int updateAmount(Contract contract){
        return contractMapper.updateByPrimaryKeySelective(contract);

    }
}
