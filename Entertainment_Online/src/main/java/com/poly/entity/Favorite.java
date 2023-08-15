package com.poly.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

//@NamedNativeQueries({
//@NamedNativeQuery(name = "Report.year",
//query = "SELECT\r\n"
//		+ "v.Title AS 'Group',\r\n"
//		+ "count(f.Id) AS 'Likes',\r\n"
//		+ "max(f.LikeDate) AS 'Newest',\r\n"
//		+ "min(f.LikeDate) AS 'Oldest'\r\n"
//		+ "FROM Favorite f JOIN Video v ON v.Id = f.VideoId\r\n"
//		+ "GROUP BY v.Title", 
//resultClass = Favorite.class)
//})

@Entity
@Table(name = "Favorite", uniqueConstraints = {@UniqueConstraint(columnNames = {"UserID","VideoID"})
})
public class Favorite {
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id 
	@Column(name = "Id")
	int Id;
	@ManyToOne(cascade = CascadeType.MERGE) @JoinColumn(name = "UserID", referencedColumnName = "Id")
	Users user;
	@ManyToOne(cascade = CascadeType.MERGE) @JoinColumn(name = "VideoID", referencedColumnName = "Id")
	Video video;
	@Temporal(TemporalType.DATE)
	Date likeDate = new Date();
	
	public Favorite() {
		super();
	}

	public Favorite(int id, Users user, Video video, Date likeDate) {
		super();
		Id = id;
		this.user = user;
		this.video = video;
		this.likeDate = likeDate;
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

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	
}
