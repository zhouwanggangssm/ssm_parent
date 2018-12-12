package cn.xt.service;

import cn.xt.dao.FinanceMapper;
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
 * 财务业务层
 */
@Service
public class FinanceService {
    @Autowired
    private FinanceMapper financeMapper;
    @Autowired
    private InvoiceMapper invoiceMapper;

    /**
     * 查询所有财务信息
     *
     * @return
     */
    public List<Finance> findPage() {
        return financeMapper.selectByExample(null);
    }

    /**
     * 查询委托为2的对象
     *
     * @return
     */
    public List<Invoice> findInvoiceList() {
        InvoiceExample example = new InvoiceExample();
        InvoiceExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(2);
        return invoiceMapper.selectByExample(example);
    }

    /**
     * 新增
     *
     * @param finance
     */
    public void insert(Finance finance) {
        //查询委托单并且修改状态为2
        Invoice invoice = invoiceMapper.selectByPrimaryKey(finance.getFinanceId());
        invoice.setState(2);
        //更新
        invoiceMapper.updateByPrimaryKeySelective(invoice);

        //状态默认为0
        finance.setState(0);
        //新增
        financeMapper.insertSelective(finance);
    }

    /**
     * 根据id查看
     *
     * @param financeId
     */
    public Finance get(String financeId) {
        return financeMapper.selectByPrimaryKey(financeId);
    }

    /**
     * 修改
     *
     * @param finance
     */
    public void update(Finance finance) {
        financeMapper.updateByPrimaryKeySelective(finance);
    }

    /**
     * 删除单个
     *
     * @param financeId
     */
    public void delete(String financeId) {
        financeMapper.deleteByPrimaryKey(financeId);
    }

    /**
     * 批量删除
     *
     * @param list
     */
    public void deleteBarch(List<String> list) {
        FinanceExample example = new FinanceExample();
        FinanceExample.Criteria criteria = example.createCriteria();
        //andFinanceIdIn(list);
        criteria.andFinanceIdIn(list);
        financeMapper.deleteByExample(example);
    }

    /**
     * 修改状态
     */
    public int updateStates(Map<String, Object> map) {
        return financeMapper.updateState(map);
    }
}