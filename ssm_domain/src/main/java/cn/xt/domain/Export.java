package cn.xt.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * 报运类
 */
public class Export implements Serializable {
    /*private Set<ExportProduct> exportProducts;	//报运下的货物 1对多*/

    private String exportId;

    private String epnum;

    private String extnum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputDate;				//制单日期

    private String contractIds;			//打断字段，报运相关的多个合同的ID集合串

    private String customerContract;	//合同及确认书号

    private String lcno;				//信用证号

    private String consignee;			//收货人及地址

    private String marks;				//唛头

    private String shipmentPort;		//装船港

    private String destinationPort;		//目的港

    private String transportMode;		//船运SEA/空运AIR 运输方式

    private String priceCondition;		//FBO/CIF价格条件

    private String remark;				//备注

    private Integer boxNums;			//冗余，为委托服务，一个报运的总箱数

    private Double grossWeights;		//冗余，为委托服务，一个报运的总毛重grossWeights

    private Double measurements;		//冗余，为委托服务，一个报运的总体积

    private Integer state;				//0-草稿 1-已上报 2-装箱 3-委托 4-发票 5-财务

    private String createBy;

    private String createDept;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    public String getEpnum() {
        return epnum;
    }

    public void setEpnum(String epnum) {
        this.epnum = epnum;
    }

    public String getExtnum() {
        return extnum;
    }

    public void setExtnum(String extnum) {
        this.extnum = extnum;
    }

    public String getExportId() {
        return exportId;
    }

    public void setExportId(String exportId) {
        this.exportId = exportId == null ? null : exportId.trim();
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getContractIds() {
        return contractIds;
    }

    public void setContractIds(String contractIds) {
        this.contractIds = contractIds == null ? null : contractIds.trim();
    }

    public String getCustomerContract() {
        return customerContract;
    }

    public void setCustomerContract(String customerContract) {
        this.customerContract = customerContract == null ? null : customerContract.trim();
    }

    public String getLcno() {
        return lcno;
    }

    public void setLcno(String lcno) {
        this.lcno = lcno == null ? null : lcno.trim();
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks == null ? null : marks.trim();
    }

    public String getShipmentPort() {
        return shipmentPort;
    }

    public void setShipmentPort(String shipmentPort) {
        this.shipmentPort = shipmentPort == null ? null : shipmentPort.trim();
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort == null ? null : destinationPort.trim();
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode == null ? null : transportMode.trim();
    }

    public String getPriceCondition() {
        return priceCondition;
    }

    public void setPriceCondition(String priceCondition) {
        this.priceCondition = priceCondition == null ? null : priceCondition.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getBoxNums() {
        return boxNums;
    }

    public void setBoxNums(Integer boxNums) {
        this.boxNums = boxNums;
    }

    public Double getGrossWeights() {
        return grossWeights;
    }

    public void setGrossWeights(Double grossWeights) {
        this.grossWeights = grossWeights;
    }

    public Double getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Double measurements) {
        this.measurements = measurements;
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

/*    public Set<ExportProduct> getExportProducts() {
        return exportProducts;
    }

    public void setExportProducts(Set<ExportProduct> exportProducts) {
        this.exportProducts = exportProducts;
    }*/
}