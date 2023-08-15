package com.poly.dao;

import javax.persistence.EntityManager;

import com.poly.entity.Share;
import com.poly.utils.Utils;

public class ShareDao {
	private EntityManager em = Utils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public Share create(Share entity) {
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
}
