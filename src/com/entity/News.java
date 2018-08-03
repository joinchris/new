package com.entity;

import java.util.Date;


public class News {
	/*
	 *用户id
	 */
	private int nid;
	/*
	 * 报社
	 */
	private int ntid;
	/*
	 * 新闻标题
	 */
	private String ntitle;
	/*
	 * 新闻类别
	 */
	private String nauthor;
	/*
	 * 新闻创建时间
	 */
	private Date ncreateDate;
	/*
	 * 图片
	 */
	private String npicPath;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public int getNtid() {
		return ntid;
	}
	public void setNtid(int ntid) {
		this.ntid = ntid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNauthor() {
		return nauthor;
	}
	public void setNauthor(String nauthor) {
		this.nauthor = nauthor;
	}
	public Date getNcreateDate() {
		return ncreateDate;
	}
	public void setNcreateDate(Date ncreateDate) {
		this.ncreateDate = ncreateDate;
	}
	public String getNpicPath() {
		return npicPath;
	}
	public void setNpicPath(String npicPath) {
		this.npicPath = npicPath;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Date getNmodifyDate() {
		return nmodifyDate;
	}
	public void setNmodifyDate(Date nmodifyDate) {
		this.nmodifyDate = nmodifyDate;
	}
	public String getNsummary() {
		return nsummary;
	}
	public void setNsummary(String nsummary) {
		this.nsummary = nsummary;
	}
	/*
	 * 新闻内容
	 */
	private String ncontent;
	/*
	 *内容更新时间 
	 */
	private Date nmodifyDate;
	/*
	 * 结尾标题
	 */
	private String nsummary;
	
}
