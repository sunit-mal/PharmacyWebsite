package com.webPage.PharmacyWebsite.DAO;

import java.util.List;

import com.webPage.PharmacyWebsite.Model.ReceiptGenaration;

public interface ReceiptGenarationDao {
	List<ReceiptGenaration> getList();
//	ReceiptGenaration get(int id);
	void save(ReceiptGenaration data);
	void delete(int id);
	void removeAll();
}
