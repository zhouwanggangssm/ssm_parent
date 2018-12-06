package cn.xt.dao;

import cn.xt.domain.Factory;
import cn.xt.domain.FactoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FactoryMapper {
    long countByExample(FactoryExample example);

    int deleteByExample(FactoryExample example);

    int deleteByPrimaryKey(String factoryId);

    int insert(Factory record);

    int insertSelective(Factory record);

    List<Factory> selectByExample(FactoryExample example);

    Factory selectByPrimaryKey(String factoryId);

    int updateByExampleSelective(@Param("record") Factory record, @Param("example") FactoryExample example);

    int updateByExample(@Param("record") Factory record, @Param("example") FactoryExample example);

    int updateByPrimaryKeySelective(Factory record);

    int updateByPrimaryKey(Factory record);

    /*查询厂家列表*/
    List<Factory> selectByExamplewithf(@Param("ctype") String ctype,@Param("state") String state);

    //查询所有
    public List<Factory> selectFactoryList( @Param("text")String text,

                                            @Param("f_type")String f_type);
    //根据ID查询
    public Factory selectFactoryId(@Param("factoryId")String factoryId);


    //添加厂家信息
    public  int addFactory(@Param("factory")Factory factory);
    //启动状态
    public int upstate(@Param("factoryId")String factoryId,@Param("state")String state);
    //分页查询
    public List<Factory> fyFactory(@Param("text")String text,
                                   @Param("currentPageNo")int currentPageNo,
                                   @Param("f_type")String f_type
    );
    public int listC(@Param("text")String text,
                     @Param("f_type")String f_type);
}