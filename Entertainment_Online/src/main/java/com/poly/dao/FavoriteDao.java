package com.poly.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.Favorite;
import com.poly.entity.Users;
import com.poly.entity.Video;
import com.poly.utils.Utils;

public class FavoriteDao {
	private EntityManager em = Utils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	public Favorite findByHrefAndUser(String user, String ma) {
		try {

			em.getTransaction().begin();

			String jpql = "select o from Favorite o where o.user.id=:u and o.video.id=:hr";

			TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
			query.setParameter("u", user); 
			query.setParameter("hr", ma);

			Favorite Favorite = query.getSingleResult();

			em.getTransaction().commit();
			
			return Favorite;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	public Favorite create(Favorite entity) {
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
	public Favorite delete(String u, String ma) {
		try {
			Favorite entity = this.findByHrefAndUser(u, ma);
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
