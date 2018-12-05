package cn.xt.dao;

import cn.xt.domain.Finance;
import cn.xt.domain.FinanceExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface FinanceMapper {
    /**
     * 修改状态
     * @param paramString
     * @return
     */
    public int updateState(Map paramString);

    long countByExample(FinanceExample example);

    int deleteByExample(FinanceExample example);

    int deleteByPrimaryKey(String financeId);

    int insert(Finance record);

    int insertSelective(Finance record);

    List<Finance> selectByExample(FinanceExample example);

    Finance selectByPrimaryKey(String financeId);

    int updateByExampleSelective(@Param("record") Finance record, @Param("example") FinanceExample example);

    int updateByExample(@Param("record") Finance record, @Param("example") FinanceExample example);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);
}