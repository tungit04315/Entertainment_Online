package com.poly.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "Report.videoShareByID", 
			procedureName = "GetSharesByEmails", 
			resultClasses = { ReportVideoShare.class },
			parameters = {
			@StoredProcedureParameter(name = "VideoID", type = String.class) }
			) 
	})

@Entity
public class ReportVideoShare implements Serializable {
	@Id
	String FullName;
	String Email;
	String Emails;
	Date Sharedate;
	
	public ReportVideoShare() {
		super();
	}

	public ReportVideoShare(String fullName, String email, String emails, Date sharedate) {
		super();
		FullName = fullName;
		Email = email;
		Emails = emails;
		Sharedate = sharedate;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getEmails() {
		return Emails;
	}

	public void setEmails(String emails) {
		Emails = emails;
	}

	public Date getSharedate() {
		return Sharedate;
	}

	public void setSharedate(Date sharedate) {
		Sharedate = sharedate;
	}
	
	
}
