package com.webPage.PharmacyWebsite.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webPage.PharmacyWebsite.Model.InvoiceData;
import com.webPage.PharmacyWebsite.Model.SellMedicine;

import jakarta.persistence.EntityManager;

@Repository
public class InvoiceGenarationDAOImplimentation implements InvoiceGenaration {

	@Autowired
	private EntityManager em;
	
	@Override
	public List<InvoiceData> getInvoicedata() {
		Session session = em.unwrap(Session.class);
		Query<InvoiceData> query = session.createQuery("from InvoiceData",InvoiceData.class);
		List<InvoiceData> list = query.getResultList();
		return list;
	}

	@Override
	public List<SellMedicine> getMedicineList() {
		Session session = em.unwrap(Session.class);
		Query<SellMedicine> query = session.createQuery("from SellMedicine",SellMedicine.class);
		List<SellMedicine> list = query.getResultList();
		return list;
	}

	@Override
	public InvoiceData getInvoiceData(int id) {
		Session session = em.unwrap(Session.class);
		InvoiceData data = session.get(InvoiceData.class, id);
		return data;
	}

	@Override
	public SellMedicine getMedicine(int id) {
		Session session = em.unwrap(Session.class);
		SellMedicine data = session.get(SellMedicine.class, id);
		return data;
	}

	@Override
	public void saveInvoiceData(InvoiceData data) {
		Session session = em.unwrap(Session.class);
		session.merge(data);
		
	}

	@Override
	public void saveMedicineList(SellMedicine data) {
		Session session = em.unwrap(Session.class);
		session.merge(data);
		
	}

}
