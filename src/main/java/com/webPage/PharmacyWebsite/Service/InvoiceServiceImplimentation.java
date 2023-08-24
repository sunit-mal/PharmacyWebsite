package com.webPage.PharmacyWebsite.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webPage.PharmacyWebsite.DAO.InvoiceGenaration;
import com.webPage.PharmacyWebsite.Model.InvoiceData;
import com.webPage.PharmacyWebsite.Model.SellMedicine;

@Service
public class InvoiceServiceImplimentation implements InvoiceService {
	
	@Autowired
	private InvoiceGenaration ig; 
	
	@Override
	public List<InvoiceData> getInvoicedata() {
		// TODO Auto-generated method stub
		return ig.getInvoicedata();
	}

	@Override
	public List<SellMedicine> getMedicineList() {
		// TODO Auto-generated method stub
		return ig.getMedicineList();
	}

	@Override
	public InvoiceData getInvoiceData(int id) {
		// TODO Auto-generated method stub
		return ig.getInvoiceData(id);
	}

	@Override
	public SellMedicine getMedicine(int id) {
		// TODO Auto-generated method stub
		return ig.getMedicine(id);
	}

	@Override
	public void saveInvoiceData(InvoiceData data) {
		ig.saveInvoiceData(data);

	}

	@Override
	public void saveMedicineList(SellMedicine data) {
		ig.saveMedicineList(data);

	}

}
