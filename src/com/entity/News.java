package com.entity;

import java.util.Date;


public class News {
	/*
	 *�û�id
	 */
	private int nid;
	/*
	 * ����
	 */
	private int ntid;
	/*
	 * ���ű���
	 */
	private String ntitle;
	/*
	 * �������
	 */
	private String nauthor;
	/*
	 * ���Ŵ���ʱ��
	 */
	private Date ncreateDate;
	/*
	 * ͼƬ
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
	 * ��������
	 */
	private String ncontent;
	/*
	 *���ݸ���ʱ�� 
	 */
	private Date nmodifyDate;
	/*
	 * ��β����
	 */
	private String nsummary;
	
}
