package cn.xt.dao;

import cn.xt.domain.Contract;
import cn.xt.domain.ContractExample;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ContractMapper {
    int countByExample(ContractExample example);

    int deleteByExample(ContractExample example);

    /*删除单个*/
    int deleteByPrimaryKey(String contractId);

    int insert(Contract record);

    /*添加*/
    int insertSelective(Contract record);

    /*根据状态查询购销合同信息*/
    List<Contract> selectByExamplewithState(@Param(("state")) Integer state);

    /*根据id查询信息*/
    Contract selectByPrimaryKeywithcp(String contractId);

    /**
     *查询所有
     * @param paramMap
     * @return
     */
    public  List<Contract> find(Map paramMap);

    /**
     * 根据id查询对象
     * @param paramString
     * @return
     */
    public Contract view(Serializable paramString);

    /**
     * 修改状态
     * @param paramString
     * @return
     */
    public int updateState(Map paramString);

    List<Contract> selectByExample(ContractExample example);

    Contract selectByPrimaryKey(String contractId);

    int updateByExampleSelective(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByExample(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
}