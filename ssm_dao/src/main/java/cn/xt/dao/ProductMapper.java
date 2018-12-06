package cn.xt.dao;

import cn.xt.domain.Factory;
import cn.xt.domain.Product;
import cn.xt.domain.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    //查询
    public List<Product> selectProdList(@Param("id")String id,
                                        @Param("factoryName")String factoryName);

    //根据ID查询
    public Product productList(@Param("productId")String productId);
    //删除
    int detproduct(@Param("productId")String productId);

    //查询厂家信息的厂家简称
    List<Factory> selectfactoryadd();

}