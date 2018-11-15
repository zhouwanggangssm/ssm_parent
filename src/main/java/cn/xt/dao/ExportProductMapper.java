package cn.xt.dao;

import cn.xt.domain.ExportProduct;
import cn.xt.domain.ExportProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExportProductMapper {
    long countByExample(ExportProductExample example);

    int deleteByExample(ExportProductExample example);

    int deleteByPrimaryKey(String exportProductId);

    int insert(ExportProduct record);

    int insertSelective(ExportProduct record);

    List<ExportProduct> selectByExample(ExportProductExample example);

    ExportProduct selectByPrimaryKey(String exportProductId);

    int updateByExampleSelective(@Param("record") ExportProduct record, @Param("example") ExportProductExample example);

    int updateByExample(@Param("record") ExportProduct record, @Param("example") ExportProductExample example);

    int updateByPrimaryKeySelective(ExportProduct record);

    int updateByPrimaryKey(ExportProduct record);
}