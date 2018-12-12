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

/**
 * 购销合同下货物业务层
 */
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
        //id 生成UUID 把-替换
        contractProduct.setContractProductId(UUID.randomUUID().toString().replace("-",""));
        //判断价格跟数量不等于空
        if(contractProduct.getPrice() != 0 && contractProduct.getCnumber() != null){
            //创建Arith对象
            Arith arith = new Arith(); //java精度工具类
            //调用mul方法
            contractProduct.setAmount(arith.mul(contractProduct.getCnumber(),contractProduct.getPrice())); //总金额
        }
        //新增
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
        //先删除子表的数据 deleteByContractProduct方法
        extCproductMapper.deleteByContractProduct(ids);
        //删除自身的数据
        contractProductMapper.deleteByPrimaryKey(contractProduct.getContractProductId());

    }

    /**
     * 根据船期查询所有信息
     * @return
     */
    public List<ContractProduct> getShipTimeList(String shipTime){
        //打印
        return contractProductMapper.selectByExamplewithShipTime(shipTime);
    }

    /**
     * 根据contractProductId查询对象
     * @return
     */
    public ContractProduct  getContractProductById(String contractProductId){
       return contractProductMapper.selectByPrimaryKey(contractProductId);
    }


}
