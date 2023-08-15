package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.Video;
import com.poly.utils.Utils;

public class VideoDao {
	private EntityManager em = Utils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}

	public Video findById(String id) {
		Video entity = em.find(Video.class, id);
		return entity;
	}

	public Video findByHref(String keyword) {
		try {

			em.getTransaction().begin();

			String jpql = "SELECT u FROM Video u WHERE u.href LIKE ?0";

			TypedQuery<Video> query = em.createQuery(jpql, Video.class);
			query.setParameter(0, "%" + keyword + "%");

			Video video = query.getSingleResult();

			em.getTransaction().commit();
			
			return video;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	public Video findByTitle(String keyword) {
		try {

			em.getTransaction().begin();

			String jpql = "SELECT u FROM Video u WHERE u.Title LIKE ?0";

			TypedQuery<Video> query = em.createQuery(jpql, Video.class);
			query.setParameter(0, "%" + keyword + "%");

			Video video = query.getSingleResult();

			em.getTransaction().commit();
			
			return video;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public List<Video> findAll() {
		String sql = "select u from Video u";
		TypedQuery<Video> query = em.createQuery("select u from Video u", Video.class);
		List<Video> list = query.getResultList();
		return list;
	}

	public Video create(Video entity) {
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

	public Video update(Video entity) {
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

	public Video delete(String id) {
		try {
			Video entity = this.findById(id);
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
