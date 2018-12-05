package cn.xt.dao;

import cn.xt.domain.ShippingOrder;
import cn.xt.domain.ShippingOrderExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ShippingOrderMapper {
    /**
     * 修改状态
     * @param paramString
     * @return
     */
    public int updateState(Map paramString);

    long countByExample(ShippingOrderExample example);

    int deleteByExample(ShippingOrderExample example);

    int deleteByPrimaryKey(String shippingOrderId);

    int insert(ShippingOrder record);

    int insertSelective(ShippingOrder record);

    List<ShippingOrder> selectByExample(ShippingOrderExample example);

    ShippingOrder selectByPrimaryKey(String shippingOrderId);

    int updateByExampleSelective(@Param("record") ShippingOrder record, @Param("example") ShippingOrderExample example);

    int updateByExample(@Param("record") ShippingOrder record, @Param("example") ShippingOrderExample example);

    int updateByPrimaryKeySelective(ShippingOrder record);

    int updateByPrimaryKey(ShippingOrder record);
}