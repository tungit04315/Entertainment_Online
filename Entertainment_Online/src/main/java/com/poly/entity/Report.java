package com.poly.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "Report.favoriteByYear", 
				procedureName = "spFavoriteByYear", 
				resultClasses = { Report.class },
				parameters = {
				@StoredProcedureParameter(name = "Year", type = Integer.class) }
				) 
		})

@Entity
public class Report implements Serializable {
	@Id
	String group;
	Long likes;
	Date newest;
	Date oldest;

	public Report() {
		super();
	}

	public Report(String group, Long likes, Date newest, Date oldest) {
		super();
		this.group = group;
		this.likes = likes;
		this.newest = newest;
		this.oldest = oldest;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Date getNewest() {
		return newest;
	}

	public void setNewest(Date newest) {
		this.newest = newest;
	}

	public Date getOldest() {
		return oldest;
	}

	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}

}
