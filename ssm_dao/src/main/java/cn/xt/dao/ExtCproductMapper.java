package cn.xt.dao;

import cn.xt.domain.ExtCproduct;
import cn.xt.domain.ExtCproductExample;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExtCproductMapper {
    long countByExample(ExtCproductExample example);

    int deleteByExample(ExtCproductExample example);

    int deleteByPrimaryKey(String extCproductId);

    /*级联删除*/
    int deleteByContractProduct(Serializable[] ids);

    int deleteByContractId(List<String> ids);

    int insert(ExtCproduct record);

    int insertSelective(ExtCproduct record);

    List<ExtCproduct> selectByExample(ExtCproductExample example);

    ExtCproduct selectByPrimaryKey(String extCproductId);

    int updateByExampleSelective(@Param("record") ExtCproduct record, @Param("example") ExtCproductExample example);

    int updateByExample(@Param("record") ExtCproduct record, @Param("example") ExtCproductExample example);

    int updateByPrimaryKeySelective(ExtCproduct record);

    int updateByPrimaryKey(ExtCproduct record);
}