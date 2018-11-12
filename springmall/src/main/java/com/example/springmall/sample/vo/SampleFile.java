package com.example.springmall.sample.vo;

public class SampleFile {
	private int samplefileNo;	//ai로 채움
	private int sampleNo;		//insert sample 로 채워짐
	//multipartfile로 채워짐
	private String samplefilePath;
	private String samplefileName;
	private String samplefileExt;
	private String samplefileType;
	private long samplefileSize;
	private String samplefileDate;
	public int getSamplefileNo() {
		return samplefileNo;
	}
	public void setSamplefileNo(int samplefileNo) {
		this.samplefileNo = samplefileNo;
	}
	public int getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(int sampleNo) {
		this.sampleNo = sampleNo;
	}
	public String getSamplefilePath() {
		return samplefilePath;
	}
	public void setSamplefilePath(String samplefilePath) {
		this.samplefilePath = samplefilePath;
	}
	public String getSamplefileName() {
		return samplefileName;
	}
	public void setSamplefileName(String samplefileName) {
		this.samplefileName = samplefileName;
	}
	public String getSamplefileExt() {
		return samplefileExt;
	}
	public void setSamplefileExt(String samplefileExt) {
		this.samplefileExt = samplefileExt;
	}
	public String getSamplefileType() {
		return samplefileType;
	}
	public void setSamplefileType(String samplefileType) {
		this.samplefileType = samplefileType;
	}
	public long getSamplefileSize() {
		return samplefileSize;
	}
	public void setSamplefileSize(long samplefileSize) {
		this.samplefileSize = samplefileSize;
	}
	public String getSamplefileDate() {
		return samplefileDate;
	}
	public void setSamplefileDate(String samplefileDate) {
		this.samplefileDate = samplefileDate;
	}
	
	@Override
	public String toString() {
		return "SampleFile [samplefileNo=" + samplefileNo + ", sampleNo=" + sampleNo + ", samplefilePath="
				+ samplefilePath + ", samplefileName=" + samplefileName + ", samplefileExt=" + samplefileExt
				+ ", samplefileType=" + samplefileType + ", samplefileSize=" + samplefileSize + ", samplefileDate="
				+ samplefileDate + "]";
	}
	
}
