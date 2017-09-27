package com.jiang.pojo;
/**
 * 视频类
 * @author Administrator
 *
 */
public class Food {
	/**
	 * 菜品编号
	 */
	private Integer fid;
	/**
	 * 菜品名称
	 */
	private String fname;
	/**
	 * 菜系名称
	 */
	private String cname;
	/**
	 * 菜品价格
	 */
	private Double price;
	/**
	 * vip价格
	 */
	private Double vipprice;
	/**
	 * 菜品图片路径
	 */
	private String url;
	public Food() {
		super();
	}
	public Food(Integer fid, String fname, String cname, Double price, Double vipprice, String url) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.cname = cname;
		this.price = price;
		this.vipprice = vipprice;
		this.url = url;
	}
	@Override
	public String toString() {
		return "Food [fid=" + fid + ", fname=" + fname + ", cname=" + cname + ", price=" + price + ", vipprice="
				+ vipprice + ", url=" + url + "]";
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getVipprice() {
		return vipprice;
	}
	public void setVipprice(Double vipprice) {
		this.vipprice = vipprice;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
