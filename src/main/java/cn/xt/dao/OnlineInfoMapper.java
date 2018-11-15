package cn.xt.dao;

import cn.xt.domain.OnlineInfo;
import cn.xt.domain.OnlineInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OnlineInfoMapper {
    long countByExample(OnlineInfoExample example);

    int deleteByExample(OnlineInfoExample example);

    int deleteByPrimaryKey(String a1);

    int insert(OnlineInfo record);

    int insertSelective(OnlineInfo record);

    List<OnlineInfo> selectByExample(OnlineInfoExample example);

    OnlineInfo selectByPrimaryKey(String a1);

    int updateByExampleSelective(@Param("record") OnlineInfo record, @Param("example") OnlineInfoExample example);

    int updateByExample(@Param("record") OnlineInfo record, @Param("example") OnlineInfoExample example);

    int updateByPrimaryKeySelective(OnlineInfo record);

    int updateByPrimaryKey(OnlineInfo record);
}