package com.webPage.PharmacyWebsite.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webPage.PharmacyWebsite.Model.AuthenticationData;
import com.webPage.PharmacyWebsite.Service.AuthenticationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService auth;
	
								//	Registration Method

	@Transactional
	@RequestMapping("/register")
	public String registration(HttpServletRequest request, HttpSession session) {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");

		if (pass1.equals(pass2)) {
			if (unameValidationCheck(uname)) {
				AuthenticationData authobj = new AuthenticationData();
				authobj.setName(fname + " " + lname);
				authobj.setEmail(email);
				authobj.setUserName(uname);
				authobj.setPassword(pass1);
				auth.save(authobj);
				return "redirect:/loginPage";
			} else
				session.setAttribute("massage", "Use Different User Name");
		} else {
			session.setAttribute("massage", "Password Not Match !");
		}
		return "redirect:/signupPage";
	}

	public boolean unameValidationCheck(String uname) {
		boolean check = true;
		List<AuthenticationData> list = auth.get();
		for (AuthenticationData elementData : list) {
			if (elementData.unameValidation(uname)) {
				check = false;
				break;
			}
		}
		return check;
	}

								//	Login Method
	
	@RequestMapping("/userLogin")
	public String userLogin(HttpServletRequest request, HttpSession session) {
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		List<AuthenticationData> list = auth.get();
		{
			for (AuthenticationData elementData : list) {
				if (elementData.validation(uname, pass)) {
					session.setAttribute("user", uname);
					return "redirect:/";
				}
			}
		}
		return "redirect:/loginPage";
	}
	
								//	LogOut Method
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpSession session) {
		session.setAttribute("user", null);
		return "redirect:/";
	}
}
