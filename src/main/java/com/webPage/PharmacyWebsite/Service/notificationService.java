package com.webPage.PharmacyWebsite.Service;

import java.util.List;

import com.webPage.PharmacyWebsite.Model.notification;

public interface notificationService {
	List<notification> getList();
	void save(notification data);
	void delete(int id);
}
