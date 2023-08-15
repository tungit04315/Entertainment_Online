package com.poly.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Share", uniqueConstraints = { @UniqueConstraint(columnNames = { "UserID", "VideoID" }) })
public class Share {
	@Id
	@Column(name = "Id")
	int Id;

	@ManyToOne
	@JoinColumn(name = "UserID")
	Users user;
	@ManyToOne
	@JoinColumn(name = "VideoID")
	Video video;
	@Column(name = "Emails")
	String Emails;
	@Temporal(TemporalType.DATE)
	Date shareDate = new Date();

	public Share() {
		super();
	}

	public Share(int id, Users user, Video video, String emails, Date shareDate) {
		super();
		Id = id;
		this.user = user;
		this.video = video;
		Emails = emails;
		this.shareDate = shareDate;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public String getEmails() {
		return Emails;
	}

	public void setEmails(String emails) {
		Emails = emails;
	}

	public Date getShareDate() {
		return shareDate;
	}

	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}

}
