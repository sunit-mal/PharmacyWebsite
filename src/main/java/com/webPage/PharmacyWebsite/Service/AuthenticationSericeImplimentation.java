package com.webPage.PharmacyWebsite.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webPage.PharmacyWebsite.DAO.AuthenticationDAO;
import com.webPage.PharmacyWebsite.Model.AuthenticationData;

@Service
public class AuthenticationSericeImplimentation implements AuthenticationService {
	
	@Autowired 
	private AuthenticationDAO auth;
	
	@Override
	public List<AuthenticationData> get() {
		return auth.get();
	}

	@Override
	public void save(AuthenticationData data) {
		auth.save(data);
	}

}
