package com.poly.entity;

import java.util.List;

import javax.persistence.*;

@NamedQueries({
@NamedQuery(name = "Video.findByUser",
query = "SELECT o.video FROM Favorite o"
+ " WHERE o.user.Id=:id"),
@NamedQuery(name = "Video.findByKeyword",
query = "SELECT DISTINCT o.video FROM Favorite o"
+ " WHERE o.video.Title LIKE :keyword")
})

@NamedNativeQueries({
@NamedNativeQuery(name = "Report.random10",
query = "SELECT TOP 10 * FROM Video ORDER BY newid()", 
resultClass = Video.class),
@NamedNativeQuery(name = "Report.year",
query = "SELECT"
		+ "v.Title AS 'Group',"
		+ "count(f.Id) AS 'Likes',"
		+ "max(f.LikeDate) AS 'Newest',"
		+ "min(f.LikeDate) AS 'Oldest'"
		+ "FROM Favorite f JOIN Video v ON v.Id = f.VideoId"
		+ "GROUP BY v.Title", 
resultClass = Video.class),
@NamedNativeQuery(name = "Report.spVideoShareByTitle",
query = "SELECT"
		+ "v.Title AS 'Group',"
		+ "count(f.Id) AS 'Likes',"
		+ "max(f.LikeDate) AS 'Newest',"
		+ "min(f.LikeDate) AS 'Oldest'"
		+ "FROM Favorite f JOIN Video v ON v.Id = f.VideoId"
		+ "GROUP BY v.Title", 
resultClass = Video.class)
})



@Entity
@Table(name = "Video")
public class Video {
	@Id
	@Column(name = "Id")
	String Id;
	@Column(name = "Title")
	String Title;
	@Column(name = "Poster")
	String Poster;
	@Column(name = "Viewss")
	int Viewss;
	@Column(name = "Descriptions")
	String Descriptions;
	@Column(name = "Active")
	boolean Active;
	@Column(name = "href")
	String href;

	@OneToMany(mappedBy = "video")
	List<Favorite> favorites;
	
	@OneToMany(mappedBy = "video")
	List<Share> share;

	public Video() {
		super();
	}

	public Video(String id, String title, String poster, int viewss, String descriptions, boolean active, String href,
			List<Favorite> favorites, List<Share> share) {
		super();
		Id = id;
		Title = title;
		Poster = poster;
		Viewss = viewss;
		Descriptions = descriptions;
		Active = active;
		this.href = href;
		this.favorites = favorites;
		this.share = share;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}

	public int getViewss() {
		return Viewss;
	}

	public void setViewss(int viewss) {
		Viewss = viewss;
	}

	public String getDescriptions() {
		return Descriptions;
	}

	public void setDescriptions(String descriptions) {
		Descriptions = descriptions;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public List<Share> getShare() {
		return share;
	}

	public void setShare(List<Share> share) {
		this.share = share;
	}

	

}
