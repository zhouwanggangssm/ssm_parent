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
import java.util.UUID;

/**
 * 附件业务层
 */
@Service
public class ExtCproductService {
    @Autowired
    private ExtCproductMapper extCproductMapper;
    @Autowired
    private FactoryMapper factoryMapper;
    @Autowired
    private ContractMapper contractMapper;
    /**
     * 查询厂家名称列表
     * @param ctype
     * @param state
     * @return
     */
    public List<Factory> factoryList(String ctype, String state){
        return factoryMapper.selectByExamplewithf(ctype,state);
    }

    /**
     * 查询厂家信息，附件信息
     * @return
     */
    public List<ExtCproduct> queryListAll(String contractProductId){
        //实例化ExtCproductExample对象
        ExtCproductExample example = new ExtCproductExample();

        ExtCproductExample.Criteria criteria = example.createCriteria();

        //调用andContractProductIdEqualTo方法，根据id查询所有附件
        criteria.andContractProductIdEqualTo(contractProductId);

        //创建List集合
        List<ExtCproduct> list = extCproductMapper.selectByExample(example);

        return list;
    }

    /**
     * 添加附件信息
     */
    public void add(ExtCproduct extCproduct){
        //定义double类型的变量
       double amount = 0d;

        //随机生成UUID
        String uuid = UUID.randomUUID().toString();

        //把"-" 替换成""
        String s = uuid.replace("-", "");

        //附件id
       extCproduct.setExtCproductId(s);

        //用工具类判断价格&&数量是否为空
        if (UtilFuns.isNotEmpty(extCproduct.getPrice()) && UtilFuns.isNotEmpty(extCproduct.getCnumber())) {

            //货物总金额
            amount = (extCproduct.getPrice()*extCproduct.getCnumber());

            //把总金额放进实体
            extCproduct.setAmount(amount);
        }


        //修改购销合同的总金额
        Contract contract = getContractById(extCproduct.getContractProduct().getContract().getContractId());

        //购销合同总金额加货物总金额
        contract.setTotalAmount(contract.getTotalAmount()+amount);

        //通过调用方法更新购销合同的总金额
        updateAmount(contract);

        //保存附件信息
        extCproductMapper.insertSelective(extCproduct);
    }

    /**
     * 修改附件信息
     * @param extCproduct
     * @return
     */
    public int update(ExtCproduct extCproduct){
        //先得到总金额
      double  extamount =  extCproduct.getAmount();
        if(UtilFuns.isNotEmpty(extCproduct.getPrice()) && UtilFuns.isNotEmpty(extCproduct.getCnumber())){

            //计算价格乘数量
           double amount=extCproduct.getPrice()*extCproduct.getCnumber();

            //把总金额放进实体
            extCproduct.setAmount(amount);

            //修改购销合同的总金额
            Contract contract = getContractById(extCproduct.getContractProduct().getContract().getContractId());

            //修改当前合同的总金额
            contract.setTotalAmount(contract.getTotalAmount()-extamount+amount);

            //更新购销合同的总金额
            updateAmount(contract);
        }

        //更新附件
        int i = extCproductMapper.updateByPrimaryKeySelective(extCproduct);
        return i;
    }

    /**
     * 删除附件
     * @return
     */
    public int delete(ExtCproduct extCproduct){
        //得到附件对象
        ExtCproduct extCproduct1 = extCproductMapper.selectByPrimaryKey(extCproduct.getExtCproductId());

        //得到购销合同对象
        Contract contract = contractMapper.selectByPrimaryKey(extCproduct.getContractProduct().getContract().getContractId());

        //购销合同金额减附件表的金额
        contract.setTotalAmount(contract.getTotalAmount()-extCproduct1.getAmount());

        //更新总金额
        contractMapper.updateByPrimaryKeySelective(contract);

        //删除附件
        int i = extCproductMapper.deleteByPrimaryKey(extCproduct.getExtCproductId());
        return i;
    }

    /**
     * 根据id查询附件信息
     * @return
     */
    public ExtCproduct getExtCproductById(String extCproductId){
        return extCproductMapper.selectByPrimaryKey(extCproductId);
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
