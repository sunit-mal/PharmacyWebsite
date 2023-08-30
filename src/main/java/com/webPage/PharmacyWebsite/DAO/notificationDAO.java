package com.webPage.PharmacyWebsite.DAO;

import java.util.List;

import com.webPage.PharmacyWebsite.Model.notification;

public interface notificationDAO {
	List<notification> getList();
	void save(notification data);
	void delete(int id);
}
