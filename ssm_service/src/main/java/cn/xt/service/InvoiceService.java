package cn.xt.service;

import cn.xt.dao.InvoiceMapper;
import cn.xt.dao.PackingListMapper;
import cn.xt.dao.ShippingOrderMapper;
import cn.xt.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 发票业务层
 */
@Service
public class InvoiceService {
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Autowired
    private ShippingOrderMapper shippingOrderMapper;
    @Autowired
    private PackingListMapper packingListMapper;

    /**
     * 查询所有发票信息
     *
     * @return
     */
    public List<Invoice> findPage() {
        return invoiceMapper.selectByExample(null);
    }

    /**
     * 查询状态为2的装箱
     *
     * @return
     */
    public List<ShippingOrder> findShippingList() {
        ShippingOrderExample example = new ShippingOrderExample();
        ShippingOrderExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(2);
        return shippingOrderMapper.selectByExample(example);
    }

    /**
     * 新增
     *
     * @param invoice
     */
    public void insert(Invoice invoice) {
        //根据委托id查询装箱的对象
        PackingList packingList = packingListMapper.selectByPrimaryKey(invoice.getInvoiceId());
        //把状态改为2 已委托
        packingList.setState(2);
        String[] split = packingList.getExportNos().split(",");
        //报运单合同号
        invoice.setScNo(split[0]);

        //修改装箱单的发票号和日期
        packingList.setInvoiceNo(invoice.getBlNo());
        packingList.setInvoiceDate(new Date());
        //再更新
        packingListMapper.updateByPrimaryKeySelective(packingList);

        //查询委托单并且修改状态为3
        ShippingOrder shippingOrder = shippingOrderMapper.selectByPrimaryKey(invoice.getInvoiceId());
        shippingOrder.setState(3);
        //更新
        shippingOrderMapper.updateByPrimaryKeySelective(shippingOrder);

        //状态默认为0
        invoice.setState(0);
        //发票时间
        invoice.setCreateTime(new Date());
        //新增
        invoiceMapper.insertSelective(invoice);
    }

    /**
     * 根据id查看
     *
     * @param invoiceId
     */
    public Invoice get(String invoiceId) {
        return invoiceMapper.selectByPrimaryKey(invoiceId);
    }

    /**
     * 修改
     *
     * @param invoice
     */
    public void update(Invoice invoice) {
        invoiceMapper.updateByPrimaryKeySelective(invoice);
    }

    /**
     * 删除单个
     *
     * @param invoiceId
     */
    public void delete(String invoiceId) {
        invoiceMapper.deleteByPrimaryKey(invoiceId);
    }

    /**
     * 批量删除
     *
     * @param list
     */
    public void deleteBarch(List<String> list) {
        InvoiceExample example = new InvoiceExample();
        InvoiceExample.Criteria criteria = example.createCriteria();
        criteria.andInvoiceIdIn(list);
        invoiceMapper.deleteByExample(example);
    }

    /**
     * 修改状态
     */
    public int updateStates(Map<String, Object> map) {
        return invoiceMapper.updateState(map);
    }
}