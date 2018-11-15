package cn.xt.dao;

import cn.xt.domain.Feedback;
import cn.xt.domain.FeedbackExample;
import cn.xt.domain.FeedbackWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeedbackMapper {
    long countByExample(FeedbackExample example);

    int deleteByExample(FeedbackExample example);

    int deleteByPrimaryKey(String feedbackId);

    int insert(FeedbackWithBLOBs record);

    int insertSelective(FeedbackWithBLOBs record);

    List<FeedbackWithBLOBs> selectByExampleWithBLOBs(FeedbackExample example);

    List<Feedback> selectByExample(FeedbackExample example);

    FeedbackWithBLOBs selectByPrimaryKey(String feedbackId);

    int updateByExampleSelective(@Param("record") FeedbackWithBLOBs record, @Param("example") FeedbackExample example);

    int updateByExampleWithBLOBs(@Param("record") FeedbackWithBLOBs record, @Param("example") FeedbackExample example);

    int updateByExample(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByPrimaryKeySelective(FeedbackWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FeedbackWithBLOBs record);

    int updateByPrimaryKey(Feedback record);
}