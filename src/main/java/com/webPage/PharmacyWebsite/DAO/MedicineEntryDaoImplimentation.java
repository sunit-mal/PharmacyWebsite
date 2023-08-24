package com.webPage.PharmacyWebsite.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webPage.PharmacyWebsite.Model.MedicineEntryData;

import jakarta.persistence.EntityManager;

@Repository
public class MedicineEntryDaoImplimentation implements MedicineEntryDao {

	@Autowired
	private EntityManager em;
	
	@Override
	public List<MedicineEntryData> getList() {
		Session session = em.unwrap(Session.class);
		Query<MedicineEntryData> query = session.createQuery("from MedicineEntryData",MedicineEntryData.class);
		List<MedicineEntryData> list = query.getResultList();
		return list;
	}

	@Override
	public MedicineEntryData get(int id) {
		Session session = em.unwrap(Session.class);
		MedicineEntryData data = session.get(MedicineEntryData.class, id);
		return data;
	}

	@Override
	public void save(MedicineEntryData data) {
		Session session = em.unwrap(Session.class);
		session.merge(data);

	}

	@Override
	public void delete(int id) {
		Session session = em.unwrap(Session.class);
		MedicineEntryData data = session.get(MedicineEntryData.class, id);
		session.remove(data);

	}

	@Override
	public void update(int id, MedicineEntryData data) {
		delete(id);
		save(data);
	}

}
