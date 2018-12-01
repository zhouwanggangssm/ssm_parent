package cn.xt.service;


import cn.xt.dao.ContractMapper;
import cn.xt.dao.ContractProductMapper;
import cn.xt.dao.ExtCproductMapper;
import cn.xt.domain.Contract;
import cn.xt.domain.ContractExample;
import cn.xt.domain.ExtCproduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ContractService {
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private ContractProductMapper contractProductMapper;
    @Autowired
    private ExtCproductMapper extCproductMapper;
    /**
     * 根据状态查询购销合同
     * @return
     */
    public List<Contract> getStateFindPage(Integer state){
        return contractMapper.selectByExamplewithState(state);
    }

    /**
     * 查询所有购销合同信息
     * @return
     */
    public List<Contract> findpage(){
        return contractMapper.find(null);
    }

    /**
     * 根据Id查询信息
     * @return
     */
    public Contract getIdInfo(String id){
        return contractMapper.view(id);
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

        List<String> ids = new ArrayList<>();
        ids.add(id);
        //级联删除附件
        extCproductMapper.deleteByContractId(ids);
        //级联删除货物
        contractProductMapper.deleteByContactProductById(ids);
        //删除购销合同
        contractMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteBatch(List<String> ids) {
        //级联删除附件
        extCproductMapper.deleteByContractId(ids);

        //删除货物表的数据
        contractProductMapper.deleteByContactProductById(ids);

        //删除购销合同
        ContractExample example = new ContractExample();
        ContractExample.Criteria criteria =  example.createCriteria();
        criteria.andContractIdIn(ids);
        contractMapper.deleteByExample(example);
    }

    /**
     * 改变状态
     */
    public int updateState(Map<String,Object> map){
            //状态改为1，已上报
           return contractMapper.updateState(map);
    }

    /**
     * 修改页面
     * @param id
     * @return
     */
    public Contract get(String id) {
        return contractMapper.selectByPrimaryKey(id);
    }
}



















