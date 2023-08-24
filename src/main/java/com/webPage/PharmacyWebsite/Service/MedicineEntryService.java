package com.webPage.PharmacyWebsite.Service;

import java.util.List;

import com.webPage.PharmacyWebsite.Model.MedicineEntryData;

public interface MedicineEntryService {
	List<MedicineEntryData> getList();
	MedicineEntryData get(int id);
	void save(MedicineEntryData data);
	void delete(int id);
	void update(int id, MedicineEntryData data);
}
