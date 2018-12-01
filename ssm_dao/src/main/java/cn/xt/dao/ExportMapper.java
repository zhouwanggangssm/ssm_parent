package cn.xt.dao;

import cn.xt.domain.Export;
import cn.xt.domain.ExportExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ExportMapper {
    long countByExample(ExportExample example);

    int deleteByExample(ExportExample example);

    int deleteByPrimaryKey(String exportId);

    int insert(Export record);

    int insertSelective(Export record);

    List<Export> selectByExample(ExportExample example);

    /*查询所有报运单*/
    List<Export> find();

    Export selectByPrimaryKey(String exportId);

    int updateByExampleSelective(@Param("record") Export record, @Param("example") ExportExample example);

    int updateByExample(@Param("record") Export record, @Param("example") ExportExample example);

    int updateByPrimaryKeySelective(Export record);

    int updateByPrimaryKey(Export record);
}