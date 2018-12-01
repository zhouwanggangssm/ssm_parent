package cn.xt.service;

import cn.xt.dao.ContractMapper;
import cn.xt.dao.ContractProductMapper;
import cn.xt.dao.ExtCproductMapper;
import cn.xt.dao.FactoryMapper;
import cn.xt.domain.*;
import cn.xt.utils.Arith;
import cn.xt.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
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
    public List<ContractProduct> queryListAll(ContractProduct contractProduct){
        return contractProductMapper.find(contractProduct);
    }

    /**
     * 添加货物
     */
    public void add(ContractProduct contractProduct){
        //id
        contractProduct.setContractProductId(UUID.randomUUID().toString().replace("-",""));
        if(contractProduct.getPrice() != 0 && contractProduct.getCnumber() != null){
            Arith arith = new Arith(); //java精度工具类
            contractProduct.setAmount(arith.mul(contractProduct.getCnumber(),contractProduct.getPrice())); //总金额
        }
        contractProductMapper.inserts(contractProduct);
    }

    /**
     * 修改货物
     * @param contractProduct
     */
    public void update(ContractProduct contractProduct){
        if(contractProduct.getPrice() != 0 && contractProduct.getCnumber() != null){
            Arith arith = new Arith(); //java精度工具类
            contractProduct.setAmount(arith.mul(contractProduct.getCnumber(),contractProduct.getPrice())); //总金额
        }
        //修改
        contractProductMapper.updateByPrimaryKeySelective(contractProduct);
    }

    /**
     * 删除货物和附件
     * @param contractProduct
     */
    public void delete(ContractProduct contractProduct) throws Exception {
        //转换成数组
        Serializable[] ids = {contractProduct.getContractProductId()};
        //先删除子表的数据
        extCproductMapper.deleteByContractProduct(ids);
        //删除自身的数据
        contractProductMapper.deleteByPrimaryKey(contractProduct.getContractProductId());

    }

    /**
     * 根据船期查询所有信息
     * @return
     */
    public List<ContractProduct> getShipTimeList(String shipTime){
        List<ContractProduct> contractProducts = contractProductMapper.selectByExamplewithShipTime(shipTime);
        return contractProducts;
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
