package com.poly.dao;

import java.util.List;

import javax.persistence.*;

import com.poly.entity.Users;
import com.poly.utils.Utils;

public class UserDao {
	private EntityManager em = Utils.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable{
		em.close();
		super.finalize();
	}
	
	public Users findById(String id) {
		Users entity = em.find(Users.class, id);
		return entity;
	}
	
	public List<Users> findAll(){
		String sql = "select u from Users u";
		TypedQuery<Users> query = em.createQuery("select u from Users u", Users.class);
		List<Users> list = query.getResultList();
		return list;
	}
	
	public Users create(Users entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	public Users update(Users entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	public Users delete(String id) {
		try {
			Users entity = this.findById(id);
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
}
