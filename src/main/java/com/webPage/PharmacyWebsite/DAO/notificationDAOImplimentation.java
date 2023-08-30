package com.webPage.PharmacyWebsite.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webPage.PharmacyWebsite.Model.notification;

import jakarta.persistence.EntityManager;

@Repository
public class notificationDAOImplimentation implements notificationDAO {

	@Autowired
	private EntityManager em;
	
	@Override
	public List<notification> getList() {
		Session session = em.unwrap(Session.class);
		Query<notification> query = session.createQuery("from notification",notification.class);
		List<notification> list = query.getResultList();
		return list;
	}

	@Override
	public void save(notification data) {
		Session session = em.unwrap(Session.class);
		session.merge(data);
	}

	@Override
	public void delete(int id) {
		Session session = em.unwrap(Session.class);
		notification data = session.get(notification.class, id);
		session.remove(data);
	}

}
