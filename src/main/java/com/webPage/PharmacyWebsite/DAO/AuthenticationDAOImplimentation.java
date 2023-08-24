package com.webPage.PharmacyWebsite.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webPage.PharmacyWebsite.Model.AuthenticationData;

import jakarta.persistence.EntityManager;

@Repository
public class AuthenticationDAOImplimentation implements AuthenticationDAO {

	@Autowired 
	private EntityManager em;
	
	@Override
	public List<AuthenticationData> get() {
		Session session = em.unwrap(Session.class);
		Query<AuthenticationData> query = session.createQuery("from AuthenticationData",AuthenticationData.class);
		List<AuthenticationData> list = query.getResultList();
		return list;
	}

	@Override
	public void save(AuthenticationData data) {
		Session session = em.unwrap(Session.class);
		session.merge(data);
	}

}
