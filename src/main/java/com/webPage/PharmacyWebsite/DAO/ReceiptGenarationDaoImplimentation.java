package com.webPage.PharmacyWebsite.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webPage.PharmacyWebsite.Model.ReceiptGenaration;

import jakarta.persistence.EntityManager;

@Repository
public class ReceiptGenarationDaoImplimentation implements ReceiptGenarationDao {

	@Autowired
	private EntityManager em;
	
	@Override
	public List<ReceiptGenaration> getList() {
		Session session = em.unwrap(Session.class);
		Query<ReceiptGenaration> query = session.createQuery("from ReceiptGenaration",ReceiptGenaration.class);
		List<ReceiptGenaration> list = query.getResultList();
		return list;
	}

	@Override
	public void save(ReceiptGenaration data) {
		Session session = em.unwrap(Session.class);
		session.merge(data);
	}

	@Override
	public void delete(int id) {
		Session session = em.unwrap(Session.class);
		ReceiptGenaration data = session.get(ReceiptGenaration.class, id);
		session.remove(data);
	}

	@Override
	public void removeAll() {
		Session session = em.unwrap(Session.class);
		Query<ReceiptGenaration> query = session.createQuery("from ReceiptGenaration",ReceiptGenaration.class);
		List<ReceiptGenaration> list = query.getResultList();
		for (ReceiptGenaration receiptGenaration : list) {
			session.remove(receiptGenaration);			
		}
	}

}
