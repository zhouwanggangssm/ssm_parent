package cn.xt.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 委托
 */
public class ShippingOrder implements Serializable{
    private String shippingOrderId; //id

    private String orderType;//海运/空运

    private String shipper;//货主

    private String consignee;//提单抬头

    private String notifyParty;//正本通知人

    private String lcNo;//信用证

    private String portOfLoading;//portOfLoading

    private String portOfTrans;//转船港

    private String portOfDischarge;//卸货港
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date loadingDate;//装期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date limitDate;//效期

    private String isBatch;//是否分批

    private String isTrans;//是否转船

    private String copyNum;//份数

    private String remark;//扼要说明

    private String specialCondition;//运输要求

    private String freight;//运费说明

    private String checkBy;//复核人

    private Integer state;//状态0 草稿 1已上报 2已装箱 3已生成发票

    private String createBy;

    private String createDept;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    public String getShippingOrderId() {
        return shippingOrderId;
    }

    public void setShippingOrderId(String shippingOrderId) {
        this.shippingOrderId = shippingOrderId == null ? null : shippingOrderId.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper == null ? null : shipper.trim();
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    public String getNotifyParty() {
        return notifyParty;
    }

    public void setNotifyParty(String notifyParty) {
        this.notifyParty = notifyParty == null ? null : notifyParty.trim();
    }

    public String getLcNo() {
        return lcNo;
    }

    public void setLcNo(String lcNo) {
        this.lcNo = lcNo == null ? null : lcNo.trim();
    }

    public String getPortOfLoading() {
        return portOfLoading;
    }

    public void setPortOfLoading(String portOfLoading) {
        this.portOfLoading = portOfLoading == null ? null : portOfLoading.trim();
    }

    public String getPortOfTrans() {
        return portOfTrans;
    }

    public void setPortOfTrans(String portOfTrans) {
        this.portOfTrans = portOfTrans == null ? null : portOfTrans.trim();
    }

    public String getPortOfDischarge() {
        return portOfDischarge;
    }

    public void setPortOfDischarge(String portOfDischarge) {
        this.portOfDischarge = portOfDischarge == null ? null : portOfDischarge.trim();
    }

    public Date getLoadingDate() {
        return loadingDate;
    }

    public void setLoadingDate(Date loadingDate) {
        this.loadingDate = loadingDate;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }

    public String getIsBatch() {
        return isBatch;
    }

    public void setIsBatch(String isBatch) {
        this.isBatch = isBatch == null ? null : isBatch.trim();
    }

    public String getIsTrans() {
        return isTrans;
    }

    public void setIsTrans(String isTrans) {
        this.isTrans = isTrans == null ? null : isTrans.trim();
    }

    public String getCopyNum() {
        return copyNum;
    }

    public void setCopyNum(String copyNum) {
        this.copyNum = copyNum == null ? null : copyNum.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSpecialCondition() {
        return specialCondition;
    }

    public void setSpecialCondition(String specialCondition) {
        this.specialCondition = specialCondition == null ? null : specialCondition.trim();
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight == null ? null : freight.trim();
    }

    public String getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(String checkBy) {
        this.checkBy = checkBy == null ? null : checkBy.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getCreateDept() {
        return createDept;
    }

    public void setCreateDept(String createDept) {
        this.createDept = createDept == null ? null : createDept.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}