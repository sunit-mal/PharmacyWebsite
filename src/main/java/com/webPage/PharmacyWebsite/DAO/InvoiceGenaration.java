package com.webPage.PharmacyWebsite.DAO;

import java.util.List;

import com.webPage.PharmacyWebsite.Model.InvoiceData;
import com.webPage.PharmacyWebsite.Model.SellMedicine;

public interface InvoiceGenaration {
	List<InvoiceData> getInvoicedata();
	List<SellMedicine> getMedicineList();
	InvoiceData getInvoiceData(int id);
	SellMedicine getMedicine(int id);
	void saveInvoiceData(InvoiceData data);
	void saveMedicineList(SellMedicine data);
}
