package com.webPage.PharmacyWebsite.Service;

import java.util.List;

import com.webPage.PharmacyWebsite.Model.ReceiptGenaration;

public interface ReceiptGenarationService {
	List<ReceiptGenaration> getList();
	void save(ReceiptGenaration data);
	void delete(int id);
	void removeAll();
}
