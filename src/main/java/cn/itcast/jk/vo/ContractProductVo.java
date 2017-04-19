package cn.itcast.jk.vo;

import java.util.List;

import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ExtCProduct;
import cn.itcast.jk.domain.Factory;

public class ContractProductVo {
	private String id;  
    
    private Contract contract;//将复杂的关联变成单表操作  
    private Factory factory;
    private List<ExtCProduct>  extCProductList;
    
    private String productNo;  
    private String productImage;  
    private String productDesc;//货物描述  
    private Integer cnumber;//数量  
    private Integer outNumber;//出货数量  
    private String loadingRate;//装率  
    private String boxNum;//箱数  
    private String packingUnit;//包装单位  
    private Double price;//单价  
    private Double amount;//总价  
    private Integer finished;//是否出货完毕  
    private String exts;//附件  
    private Integer orderNo;//排序号 
    
    
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public Factory getFactory() {
		return factory;
	}
	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	public List<ExtCProduct> getExtCProductList() {
		return extCProductList;
	}
	public void setExtCProductList(List<ExtCProduct> extCProductList) {
		this.extCProductList = extCProductList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Integer getCnumber() {
		return cnumber;
	}
	public void setCnumber(Integer cnumber) {
		this.cnumber = cnumber;
	}
	public Integer getOutNumber() {
		return outNumber;
	}
	public void setOutNumber(Integer outNumber) {
		this.outNumber = outNumber;
	}
	public String getLoadingRate() {
		return loadingRate;
	}
	public void setLoadingRate(String loadingRate) {
		this.loadingRate = loadingRate;
	}
	public String getBoxNum() {
		return boxNum;
	}
	public void setBoxNum(String boxNum) {
		this.boxNum = boxNum;
	}
	public String getPackingUnit() {
		return packingUnit;
	}
	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
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
	public Integer getFinished() {
		return finished;
	}
	public void setFinished(Integer finished) {
		this.finished = finished;
	}
	public String getExts() {
		return exts;
	}
	public void setExts(String exts) {
		this.exts = exts;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
    
}
