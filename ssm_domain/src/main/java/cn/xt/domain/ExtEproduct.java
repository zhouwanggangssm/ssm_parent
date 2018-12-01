package cn.xt.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExtEproduct implements Serializable{
    private ExportProduct exportProduct;		//附件和货物，多对一

    private Factory factory;					//附件和厂家，多对一

    private String extEproductId;

    private String factoryId;

    private String factoryName;//工厂名

    private String exportProductId;

    private String productNo;

    private String productImage;

    private String productDesc;

    private Integer cnumber;

    private String packingUnit;//PCS/SETS

    private Double price;

    private Double amount;//自动计算: 数量x单价

    private String productRequest;

    private Integer orderNo;

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getExtEproductId() {
        return extEproductId;
    }

    public void setExtEproductId(String extEproductId) {
        this.extEproductId = extEproductId == null ? null : extEproductId.trim();
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId == null ? null : factoryId.trim();
    }

    public String getExportProductId() {
        return exportProductId;
    }

    public void setExportProductId(String exportProductId) {
        this.exportProductId = exportProductId == null ? null : exportProductId.trim();
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

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    public Integer getCnumber() {
        return cnumber;
    }

    public void setCnumber(Integer cnumber) {
        this.cnumber = cnumber;
    }

    public String getPackingUnit() {
        return packingUnit;
    }

    public void setPackingUnit(String packingUnit) {
        this.packingUnit = packingUnit == null ? null : packingUnit.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getProductRequest() {
        return productRequest;
    }

    public void setProductRequest(String productRequest) {
        this.productRequest = productRequest == null ? null : productRequest.trim();
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public ExportProduct getExportProduct() {
        return exportProduct;
    }

    public void setExportProduct(ExportProduct exportProduct) {
        this.exportProduct = exportProduct;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}