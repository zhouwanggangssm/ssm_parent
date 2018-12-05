package cn.xt.dao;

import cn.xt.domain.Invoice;
import cn.xt.domain.InvoiceExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface InvoiceMapper {
    /**
     * 修改状态
     * @param paramString
     * @return
     */
    public int updateState(Map paramString);

    long countByExample(InvoiceExample example);

    int deleteByExample(InvoiceExample example);

    int deleteByPrimaryKey(String invoiceId);

    int insert(Invoice record);

    int insertSelective(Invoice record);

    List<Invoice> selectByExample(InvoiceExample example);

    Invoice selectByPrimaryKey(String invoiceId);

    int updateByExampleSelective(@Param("record") Invoice record, @Param("example") InvoiceExample example);

    int updateByExample(@Param("record") Invoice record, @Param("example") InvoiceExample example);

    int updateByPrimaryKeySelective(Invoice record);

    int updateByPrimaryKey(Invoice record);
}