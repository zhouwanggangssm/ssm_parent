package cn.xt.service;


import cn.xt.dao.ContractMapper;
import cn.xt.domain.Contract;
import cn.xt.domain.ContractExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractMapper contractMapper;

    /**
     * 查询所有购销合同信息
     * @return
     */
    public List<Contract> findpage(){
         List<Contract> list = contractMapper.selectByExamplewithcp(null);
        return list;
    }

    /**
     * 根据Id查询信息
     * @return
     */
    public Contract getIdInfo(String id){
        Contract contract = contractMapper.selectByPrimaryKeywithcp(id);
        return contract;
    }

    /**
     * 添加购销合同
     * @return
     */
    public void add(Contract contract){
      contractMapper.insertSelective(contract);
    }

    /**
     * 修改购销合同
     * @param contract
     * @return
     */
    public void update(Contract contract){
        contractMapper.updateByPrimaryKeySelective(contract);
    }

    /**
     * 删除单个
     * @param id
     */
    public void delete(String id){
        contractMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param idss
     */
    public void deleteBatch(List<String> idss) {
        ContractExample example = new ContractExample();
        ContractExample.Criteria criteria =  example.createCriteria();
        criteria.andContractIdIn(idss);
        contractMapper.deleteByExample(example);
    }

    /**
     * 改变状态
     */
    public void changeState(String id,Integer state){
        //获取已选中的id
        String [] ids = id.split(",");
        for (String s : ids) {
            Contract contract = contractMapper.selectByPrimaryKeywithcp(s);
            //状态改为1，已上报
            contract.setState(state);
            contractMapper.updateByPrimaryKeySelective(contract);
        }
    }
}
