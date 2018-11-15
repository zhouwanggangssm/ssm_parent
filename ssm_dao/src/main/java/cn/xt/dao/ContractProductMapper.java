package cn.xt.dao;

import cn.xt.domain.ContractProduct;
import cn.xt.domain.ContractProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractProductMapper {
    long countByExample(ContractProductExample example);

    int deleteByExample(ContractProductExample example);

    int deleteByPrimaryKey(String contractProductId);

    int insert(ContractProduct record);

    int insertSelective(ContractProduct record);

    List<ContractProduct> selectByExample(ContractProductExample example);

    ContractProduct selectByPrimaryKey(String contractProductId);

    int updateByExampleSelective(@Param("record") ContractProduct record, @Param("example") ContractProductExample example);

    int updateByExample(@Param("record") ContractProduct record, @Param("example") ContractProductExample example);

    int updateByPrimaryKeySelective(ContractProduct record);

    int updateByPrimaryKey(ContractProduct record);
}