package com.jiang.pojo;

/**
 * 菜系类
 * 
 * @author Administrator
 *
 */
public class Cuisine {
	/**
	 * 菜系编号
	 */
	private Integer cid;
	/**
	 * 菜系名称
	 */
	private String cname;
	public Cuisine() {
		super();
	}
	public Cuisine(Integer cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Cuisine [cid=" + cid + ", cname=" + cname + "]";
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
