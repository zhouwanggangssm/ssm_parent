package cn.xt.dao;

import cn.xt.domain.Contract;
import cn.xt.domain.ContractExample;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ContractHisMapper {

    int deleteByExample(ContractExample example);

    /*删除单个*/
    int deleteByPrimaryKey(String contractId);

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

    List<Contract> selectByExample(ContractExample example);

    Contract selectByPrimaryKey(String contractId);

    int updateByExampleSelective(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByExample(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
}