package cn.xt.dao;

import cn.xt.domain.PackingList;
import cn.xt.domain.PackingListExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PackingListMapper {
    /**
     * 修改状态
     * @param paramString
     * @return
     */
    public int updateState(Map paramString);

    long countByExample(PackingListExample example);

    int deleteByExample(PackingListExample example);

    int deleteByPrimaryKey(String packingListId);

    int insert(PackingList record);

    int insertSelective(PackingList record);

    List<PackingList> selectByExample(PackingListExample example);

    PackingList selectByPrimaryKey(String packingListId);

    int updateByExampleSelective(@Param("record") PackingList record, @Param("example") PackingListExample example);

    int updateByExample(@Param("record") PackingList record, @Param("example") PackingListExample example);

    int updateByPrimaryKeySelective(PackingList record);

    int updateByPrimaryKey(PackingList record);
}