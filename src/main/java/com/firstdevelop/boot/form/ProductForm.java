package com.firstdevelop.boot.form;

public class ProductForm {

	/**
	 * キー
	 */
	private String productId;
	
	/**
	 * 商品名
	 */
	private String productName;
	
	/**
	 * 販売値段
	 */
	private String productPrice;
	
	/**
	 * 値段
	 */
	private String productAccount;
	
	/**
	 * 生産日時
	 */
	private String productDate;
	
	/**
	 * 産地
	 */
	private String address;
	
	/**
	 * 商品クラスID
	 */
	private String classProductId;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductAccount() {
		return productAccount;
	}

	public void setProductAccount(String productAccount) {
		this.productAccount = productAccount;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getClassProductId() {
		return classProductId;
	}

	public void setClassProductId(String classProductId) {
		this.classProductId = classProductId;
	}
}
