package cn.xt.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class ExportProduct implements Serializable{
    private Export export;			//报运货物和报运的关系，多对一

    private Factory factory;		//报运货物和厂家的关系，多对一

    private List<ExtEproduct> extEproducts;		//报运货物和报运附件的关系，一对多

    private String exportProductId;

    private String exportId;

    private String factoryId;

    private String factoryName;

    private String productNo;

    private String packingUnit; //PCS/SETS

    private Integer cnumber;

    private Integer boxNum;

    private Double grossWeight;

    private Double netWeight;

    private Double sizeLength;

    private Double sizeWidth;

    private Double sizeHeight;

    private Double exPrice; //sales confirmation 中的价格（手填）

    private Double price;

    private Double tax; //收购单价=合同单价

    private Integer orderNo;

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getExportProductId() {
        return exportProductId;
    }

    public void setExportProductId(String exportProductId) {
        this.exportProductId = exportProductId == null ? null : exportProductId.trim();
    }

    public String getExportId() {
        return exportId;
    }

    public void setExportId(String exportId) {
        this.exportId = exportId == null ? null : exportId.trim();
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId == null ? null : factoryId.trim();
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getPackingUnit() {
        return packingUnit;
    }

    public void setPackingUnit(String packingUnit) {
        this.packingUnit = packingUnit == null ? null : packingUnit.trim();
    }

    public Integer getCnumber() {
        return cnumber;
    }

    public void setCnumber(Integer cnumber) {
        this.cnumber = cnumber;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    public Double getSizeLength() {
        return sizeLength;
    }

    public void setSizeLength(Double sizeLength) {
        this.sizeLength = sizeLength;
    }

    public Double getSizeWidth() {
        return sizeWidth;
    }

    public void setSizeWidth(Double sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

    public Double getSizeHeight() {
        return sizeHeight;
    }

    public void setSizeHeight(Double sizeHeight) {
        this.sizeHeight = sizeHeight;
    }

    public Double getExPrice() {
        return exPrice;
    }

    public void setExPrice(Double exPrice) {
        this.exPrice = exPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Export getExport() {
        return export;
    }

    public void setExport(Export export) {
        this.export = export;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public List<ExtEproduct> getExtEproducts() {
        return extEproducts;
    }

    public void setExtEproducts(List<ExtEproduct> extEproducts) {
        this.extEproducts = extEproducts;
    }
}