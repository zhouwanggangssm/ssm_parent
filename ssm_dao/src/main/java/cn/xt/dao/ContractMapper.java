package cn.xt.dao;

import cn.xt.domain.Contract;
import cn.xt.domain.ContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractMapper {
    long countByExample(ContractExample example);

    int deleteByExample(ContractExample example);

    /*删除单个*/
    int deleteByPrimaryKey(String contractId);

    int insert(Contract record);

    /*添加*/
    int insertSelective(Contract record);

    /*查询所有*/
    List<Contract> selectByExamplewithcp(ContractExample example);

    /*根据id查询信息*/
    Contract selectByPrimaryKeywithcp(String contractId);

    List<Contract> selectByExample(ContractExample example);

    Contract selectByPrimaryKey(String contractId);

    int updateByExampleSelective(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByExample(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
}