package cn.xt.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private String productId;

    private String productNo;

    private String productImage;

    private String description;

    private String factoryId;

    private String factoryName;

    private BigDecimal price;

    private BigDecimal sizeLenght;

    private BigDecimal sizeWidth;

    private BigDecimal sizeHeight;

    private String color;

    private String packing;

    private String packingUnit;

    private BigDecimal type20;

    private BigDecimal type40;

    private BigDecimal type40hc;

    private Integer qty;

    private BigDecimal cbm;

    private BigDecimal mpsizeLenght;

    private BigDecimal mpsizeWidth;

    private BigDecimal mpsizeHeight;

    private String remark;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputTime;

    private String createBy;

    private String createDept;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage == null ? null : productImage.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId == null ? null : factoryId.trim();
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSizeLenght() {
        return sizeLenght;
    }

    public void setSizeLenght(BigDecimal sizeLenght) {
        this.sizeLenght = sizeLenght;
    }

    public BigDecimal getSizeWidth() {
        return sizeWidth;
    }

    public void setSizeWidth(BigDecimal sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

    public BigDecimal getSizeHeight() {
        return sizeHeight;
    }

    public void setSizeHeight(BigDecimal sizeHeight) {
        this.sizeHeight = sizeHeight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing == null ? null : packing.trim();
    }

    public String getPackingUnit() {
        return packingUnit;
    }

    public void setPackingUnit(String packingUnit) {
        this.packingUnit = packingUnit == null ? null : packingUnit.trim();
    }

    public BigDecimal getType20() {
        return type20;
    }

    public void setType20(BigDecimal type20) {
        this.type20 = type20;
    }

    public BigDecimal getType40() {
        return type40;
    }

    public void setType40(BigDecimal type40) {
        this.type40 = type40;
    }

    public BigDecimal getType40hc() {
        return type40hc;
    }

    public void setType40hc(BigDecimal type40hc) {
        this.type40hc = type40hc;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getCbm() {
        return cbm;
    }

    public void setCbm(BigDecimal cbm) {
        this.cbm = cbm;
    }

    public BigDecimal getMpsizeLenght() {
        return mpsizeLenght;
    }

    public void setMpsizeLenght(BigDecimal mpsizeLenght) {
        this.mpsizeLenght = mpsizeLenght;
    }

    public BigDecimal getMpsizeWidth() {
        return mpsizeWidth;
    }

    public void setMpsizeWidth(BigDecimal mpsizeWidth) {
        this.mpsizeWidth = mpsizeWidth;
    }

    public BigDecimal getMpsizeHeight() {
        return mpsizeHeight;
    }

    public void setMpsizeHeight(BigDecimal mpsizeHeight) {
        this.mpsizeHeight = mpsizeHeight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
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