package cn.xt.dao;

import cn.xt.domain.UserTemp;
import cn.xt.domain.UserTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTempMapper {
    long countByExample(UserTempExample example);

    int deleteByExample(UserTempExample example);

    int deleteByPrimaryKey(String userTempId);

    int insert(UserTemp record);

    int insertSelective(UserTemp record);

    List<UserTemp> selectByExample(UserTempExample example);

    UserTemp selectByPrimaryKey(String userTempId);

    int updateByExampleSelective(@Param("record") UserTemp record, @Param("example") UserTempExample example);

    int updateByExample(@Param("record") UserTemp record, @Param("example") UserTempExample example);

    int updateByPrimaryKeySelective(UserTemp record);

    int updateByPrimaryKey(UserTemp record);
}