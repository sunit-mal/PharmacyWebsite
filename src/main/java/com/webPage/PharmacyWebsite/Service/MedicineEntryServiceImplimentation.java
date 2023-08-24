package com.webPage.PharmacyWebsite.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webPage.PharmacyWebsite.DAO.MedicineEntryDao;
import com.webPage.PharmacyWebsite.Model.MedicineEntryData;

@Service
public class MedicineEntryServiceImplimentation implements MedicineEntryService {

	@Autowired
	private MedicineEntryDao medicinedao;
	
	@Override
	public List<MedicineEntryData> getList() {
		return medicinedao.getList();
	}

	@Override
	public MedicineEntryData get(int id) {
		return medicinedao.get(id);
	}

	@Override
	public void save(MedicineEntryData data) {
		medicinedao.save(data);
	}

	@Override
	public void delete(int id) {
		medicinedao.delete(id);
	}

	@Override
	public void update(int id, MedicineEntryData data) {
		medicinedao.update(id, data);
	}

}
