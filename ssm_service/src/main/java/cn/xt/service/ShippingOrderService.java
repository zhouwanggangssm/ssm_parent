package cn.xt.service;

import cn.xt.dao.PackingListMapper;
import cn.xt.dao.ShippingOrderMapper;
import cn.xt.domain.PackingList;
import cn.xt.domain.PackingListExample;
import cn.xt.domain.ShippingOrder;
import cn.xt.domain.ShippingOrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 委托业务层
 */
@Service
public class ShippingOrderService {
    @Autowired
    private ShippingOrderMapper shippingOrderMapper;
    @Autowired
    private PackingListMapper packingListMapper;

    /**
     * 查询所有委托信息
     * @return
     */
    public List<ShippingOrder> findPage(){
        return shippingOrderMapper.selectByExample(null);
    }

    /**
     * 查询状态为1的装箱
     * @return
     */
    public List<PackingList> findPackingList(Integer state){
        PackingListExample example = new PackingListExample();
        PackingListExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(state);
        return packingListMapper.selectByExample(example);
    }

    /**
     * 新增
     * @param shippingOrder
     */
    public void insert(ShippingOrder shippingOrder) {
        //根据委托id查询装箱的对象
        PackingList packingList = packingListMapper.selectByPrimaryKey(shippingOrder.getShippingOrderId());
        //把状态改为2 已委托
        packingList.setState(2);
        //再更新
        packingListMapper.updateByPrimaryKeySelective(packingList);

        //状态默认为0
        shippingOrder.setState(0);
        shippingOrderMapper.insertSelective(shippingOrder);
    }

    /**
     * 根据id查看
     * @param shippingOrderId
     */
    public ShippingOrder get(String shippingOrderId) {
        return shippingOrderMapper.selectByPrimaryKey(shippingOrderId);
    }

    /**
     * 修改
     * @param shippingOrder
     */
    public void update(ShippingOrder shippingOrder) {
        shippingOrderMapper.updateByPrimaryKeySelective(shippingOrder);
    }

    /**
     * 删除单个
     * @param shippingOrderId
     */
    public void delete(String shippingOrderId) {
        shippingOrderMapper.deleteByPrimaryKey(shippingOrderId);
    }

    /**
     * 批量删除
     * @param list
     */
    public void deleteBarch(List<String> list) {
        ShippingOrderExample example = new ShippingOrderExample();
        ShippingOrderExample.Criteria criteria = example.createCriteria();
        criteria.andShippingOrderIdIn(list);
        shippingOrderMapper.deleteByExample(example);
    }

    /**
     * 修改状态
     */
    public int updateStates(Map<String, Object> map){
        return shippingOrderMapper.updateState(map);
    }
}
