package com.webPage.PharmacyWebsite.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webPage.PharmacyWebsite.Model.MedicineEntryData;
import com.webPage.PharmacyWebsite.Service.MedicineEntryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MedicineCheck {
	@Autowired
	private MedicineEntryService medicineEntryService;

	@RequestMapping("/checkByName")
	public String checkByName(HttpServletRequest request, HttpSession session) {
		String nameString = request.getParameter("name");

		List<MedicineEntryData> datas = medicineEntryService.getList();
		ArrayList<ArrayList<String>> result = new ArrayList<>();

		for (MedicineEntryData medicineEntryData : datas) {

			if (medicineEntryData.searchByName(nameString)) {
				ArrayList<String> temp = new ArrayList<>();
				temp.add(medicineEntryData.getMedicineName());
				temp.add(medicineEntryData.getExpiryDate());
				temp.add(Long.toString(medicineEntryData.getQuantity()));
				temp.add(Float.toString(medicineEntryData.getPrice()));
				result.add(temp);
			}
		}
		System.out.println(result);

		session.setAttribute("resultData", result);
		return "medicineCheck";
	}

	@RequestMapping("/checkByExpiry")
	public String checkByExpiry(HttpServletRequest request, HttpSession session) {
		
		String dateString = request.getParameter("expiryDate");

		List<MedicineEntryData> datas = medicineEntryService.getList();
		ArrayList<ArrayList<String>> result = new ArrayList<>();

		for (MedicineEntryData medicineEntryData : datas) {

			if (medicineEntryData.searchByExpirydate(dateString)) {
				ArrayList<String> temp = new ArrayList<>();
				temp.add(medicineEntryData.getMedicineName());
				temp.add(medicineEntryData.getExpiryDate());
				temp.add(Long.toString(medicineEntryData.getQuantity()));
				temp.add(Float.toString(medicineEntryData.getPrice()));
				result.add(temp);
			}
		}
		System.out.println(result);
		
		session.setAttribute("resultData", result);
		return "medicineCheck";
	}

	@RequestMapping("/checkByQuantity")
	public String checkByQuantity(HttpServletRequest request, HttpSession session) {
		
		long quantity =Long.valueOf(request.getParameter("quantity"));

		List<MedicineEntryData> datas = medicineEntryService.getList();
		ArrayList<ArrayList<String>> result = new ArrayList<>();

		for (MedicineEntryData medicineEntryData : datas) {

			if (medicineEntryData.searchByQuantity(quantity)) {
				ArrayList<String> temp = new ArrayList<>();
				temp.add(medicineEntryData.getMedicineName());
				temp.add(medicineEntryData.getExpiryDate());
				temp.add(Long.toString(medicineEntryData.getQuantity()));
				temp.add(Float.toString(medicineEntryData.getPrice()));
				result.add(temp);
			}
		}
		System.out.println(result);
		
		session.setAttribute("resultData", result);
		return "medicineCheck";
	}
}
