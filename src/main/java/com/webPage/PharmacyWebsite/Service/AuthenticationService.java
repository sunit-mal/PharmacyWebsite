package com.webPage.PharmacyWebsite.Service;

import java.util.List;

import com.webPage.PharmacyWebsite.Model.AuthenticationData;

public interface AuthenticationService {
	List<AuthenticationData> get();
	void save(AuthenticationData data);
}
