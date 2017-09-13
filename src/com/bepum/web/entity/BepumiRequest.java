package com.bepum.web.entity;

import java.util.Date;

public class BepumiRequest extends Member {
	
	private String no;
	private String reqId;
	private Date reqDate;
	private String applicationForm;
	private String applicationForm_Copy;
	private String HC;
	private String HC_Copy;
	private String FRC;
	private String FRC_Copy;
	private String VC;
	private String VC_Copy;
	
	public BepumiRequest() {
	}

	public BepumiRequest(String no, String reqId, Date reqDate, String applicationForm, String applicationForm_Copy,
			String hC, String hC_Copy, String fRC, String fRC_Copy, String vC, String vC_Copy) {
		this.no = no;
		this.reqId = reqId;
		this.reqDate = reqDate;
		this.applicationForm = applicationForm;
		this.applicationForm_Copy = applicationForm_Copy;
		HC = hC;
		HC_Copy = hC_Copy;
		FRC = fRC;
		FRC_Copy = fRC_Copy;
		VC = vC;
		VC_Copy = vC_Copy;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public String getApplicationForm() {
		return applicationForm;
	}

	public void setApplicationForm(String applicationForm) {
		this.applicationForm = applicationForm;
	}

	public String getApplicationForm_Copy() {
		return applicationForm_Copy;
	}

	public void setApplicationForm_Copy(String applicationForm_Copy) {
		this.applicationForm_Copy = applicationForm_Copy;
	}

	public String getHC() {
		return HC;
	}

	public void setHC(String hC) {
		HC = hC;
	}

	public String getHC_Copy() {
		return HC_Copy;
	}

	public void setHC_Copy(String hC_Copy) {
		HC_Copy = hC_Copy;
	}

	public String getFRC() {
		return FRC;
	}

	public void setFRC(String fRC) {
		FRC = fRC;
	}

	public String getFRC_Copy() {
		return FRC_Copy;
	}

	public void setFRC_Copy(String fRC_Copy) {
		FRC_Copy = fRC_Copy;
	}

	public String getVC() {
		return VC;
	}

	public void setVC(String vC) {
		VC = vC;
	}

	public String getVC_Copy() {
		return VC_Copy;
	}

	public void setVC_Copy(String vC_Copy) {
		VC_Copy = vC_Copy;
	}
	
}
