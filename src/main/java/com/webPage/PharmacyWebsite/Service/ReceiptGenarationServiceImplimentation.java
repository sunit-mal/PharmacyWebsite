package com.webPage.PharmacyWebsite.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webPage.PharmacyWebsite.DAO.ReceiptGenarationDao;
import com.webPage.PharmacyWebsite.Model.ReceiptGenaration;

@Service
public class ReceiptGenarationServiceImplimentation implements ReceiptGenarationService {

	@Autowired
	private ReceiptGenarationDao receiptGenarationDao;
	@Override
	public List<ReceiptGenaration> getList() {	
		return receiptGenarationDao.getList();
	}

	@Override
	public void save(ReceiptGenaration data) {
		receiptGenarationDao.save(data);

	}

	@Override
	public void delete(int id) {
		receiptGenarationDao.delete(id);
	}

	@Override
	public void removeAll() {
		receiptGenarationDao.removeAll();
	}

}
