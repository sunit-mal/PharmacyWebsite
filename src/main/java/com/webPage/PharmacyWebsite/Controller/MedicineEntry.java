package com.webPage.PharmacyWebsite.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webPage.PharmacyWebsite.Model.MedicineEntryData;
import com.webPage.PharmacyWebsite.Service.MedicineEntryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class MedicineEntry {
	
	@Autowired
	private MedicineEntryService medicineService; 
	
	@RequestMapping("/save")
	@Transactional
	public String medinicineEntry(HttpServletRequest request, HttpSession session) {
		String medicineName = request.getParameter("medicinename");
		String entrydate = (java.time.LocalDate.now()).toString();
		String entryData = request.getParameter(entrydate);
		String expirydate = request.getParameter("expirydate");
		long quantity = Long.valueOf(request.getParameter("quantity"));
		float price = Float.valueOf(request.getParameter("price"));
		
		MedicineEntryData medobj = new MedicineEntryData();
		
		medobj.setMedicineName(medicineName);
		medobj.setEntryDate(entryData);
		medobj.setExpiryDate(expirydate);
		medobj.setQuantity(quantity);
		medobj.setPrice(price);
		medicineService.save(medobj);
		session.setAttribute("massage", "Sucessfully add");
		return "redirect:/entry";
	}
}
