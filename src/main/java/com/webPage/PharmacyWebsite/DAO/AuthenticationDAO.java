package com.webPage.PharmacyWebsite.DAO;

import java.util.List;

import com.webPage.PharmacyWebsite.Model.AuthenticationData;

public interface AuthenticationDAO {
	List<AuthenticationData> get();
	void save(AuthenticationData data);
}
