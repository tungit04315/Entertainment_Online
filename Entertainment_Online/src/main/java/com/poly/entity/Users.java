package com.poly.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	@Id
	@Column(name = "Id")
	String Id;
	@Column(name = "Passwords")
	String Passwords;
	@Column(name = "Email")
	String Email;
	@Column(name = "FullName")
	String FullName;
	@Column(name = "Admins")
	boolean Admins = false;
	
	@OneToMany(mappedBy = "user")
	List<Favorite> favorites;
	
	@OneToMany(mappedBy = "user")
	List<Share> share;
	
	public Users() {
		super();
	}

	

	public Users(String id, String passwords, String email, String fullName, boolean admins, List<Favorite> favorites,
			List<Share> share) {
		super();
		Id = id;
		Passwords = passwords;
		Email = email;
		FullName = fullName;
		Admins = admins;
		this.favorites = favorites;
		this.share = share;
	}



	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPasswords() {
		return Passwords;
	}

	public void setPasswords(String passwords) {
		Passwords = passwords;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public boolean isAdmins() {
		return Admins;
	}

	public void setAdmins(boolean admins) {
		Admins = admins;
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
