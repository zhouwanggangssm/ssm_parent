package cn.xt.service;

import cn.xt.dao.ContractMapper;
import cn.xt.dao.ContractProductMapper;
import cn.xt.dao.FactoryMapper;
import cn.xt.domain.Contract;
import cn.xt.domain.ContractExample;
import cn.xt.domain.ContractProduct;
import cn.xt.domain.Factory;
import cn.xt.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ContractProductService {
    @Autowired
    ContractProductMapper contractProductMapper;
    @Autowired
    FactoryMapper factoryMapper;
    @Autowired
    ContractMapper contractMapper;
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
    @Transactional
    public void add(ContractProduct contractProduct){
        contractProduct.setContractId(contractProduct.getContractId().split(",")[0]);
        System.out.println(contractProduct);
        double amount = 0d;
        System.out.println(contractProduct.getContractId()+"=========================================");
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-","");
        contractProduct.setContractProductId(uuid); //货物id
        if(UtilFuns.isNotEmpty(contractProduct.getPrice()) && UtilFuns.isNotEmpty(contractProduct.getCnumber())){
            amount=contractProduct.getPrice()*contractProduct.getCnumber(); //货物总金额
            contractProduct.setAmount(amount);//把总金额放进实体
        }
        contractProductMapper.insertSelective(contractProduct);
        //修改购销合同的总金额
        Contract contract = getContractById(contractProduct.getContractId());
        if (contract.getTotalAmount() != 0) {
            contract.setTotalAmount(contract.getTotalAmount()+contractProduct.getAmount());
        }else{
            contract.setTotalAmount(contractProduct.getAmount());
        }
        //调用修改方法
        int count = updateAmount(contract);
        if(count > 0){
            System.out.println("修改成功");
        }
    }

    /**
     * 得到id
     * @param contractId
     * @return
     */
    private Contract getContractById(String contractId){
        return contractMapper.selectByPrimaryKey(contractId);
    }

    /**
     * 修改主表的总金额
     * @param contract
     * @return
     */
    private int updateAmount(Contract contract){
        int i = contractMapper.updateByPrimaryKeySelective(contract);
        return i;
    }
}
