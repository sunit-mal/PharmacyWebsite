package com.webPage.PharmacyWebsite.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webPage.PharmacyWebsite.DAO.notificationDAO;
import com.webPage.PharmacyWebsite.Model.notification;

@Service
public class notificationServiceImplimentation implements notificationService {

	@Autowired
	private notificationDAO nd;
	
	@Override
	public List<notification> getList() {
		return nd.getList();
	}

	@Override
	public void save(notification data) {
		nd.save(data);

	}

	@Override
	public void delete(int id) {
		nd.delete(id);

	}

}
