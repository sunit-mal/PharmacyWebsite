package com.webPage.PharmacyWebsite.Service;

import java.util.List;

import com.webPage.PharmacyWebsite.Model.InvoiceData;
import com.webPage.PharmacyWebsite.Model.SellMedicine;

public interface InvoiceService {
	List<InvoiceData> getInvoicedata();
	List<SellMedicine> getMedicineList();
	InvoiceData getInvoiceData(int id);
	SellMedicine getMedicine(int id);
	void saveInvoiceData(InvoiceData data);
	void saveMedicineList(SellMedicine data);
}
