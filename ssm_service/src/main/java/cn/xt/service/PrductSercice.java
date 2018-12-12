package cn.xt.service;

import cn.xt.dao.ProductMapper;
import cn.xt.domain.Factory;
import cn.xt.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 商品
 */
@Service
public class PrductSercice {

        @Autowired
    public ProductMapper productMapper;


    /**
     * 查询所有
     * @param id
     * @param factory
     * @return
     */
    public List<Product> selectProdList(String id, String factory){
        List<Product> list=productMapper.selectProdList(id,factory);
        return list;
    }

    /**
     * 根据ID查询
     * @param productId
     * @return
     */
    public Product productsList(String productId){

        return  productMapper.productList(productId);
    }

    /**
     * 添加
     * @param product
     * @return
     */
    public int addproduct(Product product){
        String s = UUID.randomUUID().toString();
        s = s.replace("-", "");
        product.setProductId(s);
        int i=productMapper.insertSelective(product);
        return i;
    }

    /**
     * 删除
     * @param productId
     * @return
     */
    public int detproduct(String productId){
        int i=productMapper.detproduct(productId);
        return i;
    }


    /**
     * 修改
     * @param product
     * @return
     */
    public int upProduct(Product product){
        int i=productMapper.updateByPrimaryKey(product);
        return i;
    }

    /**
     * 查询厂家信息
     * @return
     */
    public List<Factory> Factory(){
        List<Factory> list=productMapper.selectfactoryadd();
        return list;
    }

}
