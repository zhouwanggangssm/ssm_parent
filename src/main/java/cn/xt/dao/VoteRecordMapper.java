package cn.xt.dao;

import cn.xt.domain.VoteRecord;
import cn.xt.domain.VoteRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoteRecordMapper {
    long countByExample(VoteRecordExample example);

    int deleteByExample(VoteRecordExample example);

    int deleteByPrimaryKey(String voteRecordId);

    int insert(VoteRecord record);

    int insertSelective(VoteRecord record);

    List<VoteRecord> selectByExample(VoteRecordExample example);

    VoteRecord selectByPrimaryKey(String voteRecordId);

    int updateByExampleSelective(@Param("record") VoteRecord record, @Param("example") VoteRecordExample example);

    int updateByExample(@Param("record") VoteRecord record, @Param("example") VoteRecordExample example);

    int updateByPrimaryKeySelective(VoteRecord record);

    int updateByPrimaryKey(VoteRecord record);
}