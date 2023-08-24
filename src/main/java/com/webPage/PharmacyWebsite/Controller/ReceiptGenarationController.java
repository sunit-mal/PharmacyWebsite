package com.webPage.PharmacyWebsite.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webPage.PharmacyWebsite.Model.MedicineEntryData;
import com.webPage.PharmacyWebsite.Model.ReceiptGenaration;
import com.webPage.PharmacyWebsite.Service.MedicineEntryService;
import com.webPage.PharmacyWebsite.Service.ReceiptGenarationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class ReceiptGenarationController {
	@Autowired
	private MedicineEntryService medicineEntryService;

	@Autowired
	private ReceiptGenarationService receiptGenarationService;

	@RequestMapping("/SearchMedicine")
	public String receiptGenaration(HttpServletRequest request, HttpSession session) {
		String nameString = request.getParameter("searchData");
		if (nameString == null)
			nameString = "";
		List<MedicineEntryData> datas = medicineEntryService.getList();
		ArrayList<ArrayList<String>> result = new ArrayList<>();

		for (MedicineEntryData medicineEntryData : datas) {

			if (medicineEntryData.searchByName(nameString)) {
				ArrayList<String> temp = new ArrayList<>();
				temp.add(medicineEntryData.getMedicineName());
				temp.add(medicineEntryData.getExpiryDate());
				temp.add(Long.toString(medicineEntryData.getQuantity()));
				temp.add(Float.toString(medicineEntryData.getPrice()));
				temp.add(Integer.toString(medicineEntryData.getId()));
				result.add(temp);
			}
		}

		List<ReceiptGenaration> chooseData = receiptGenarationService.getList();
		ArrayList<ArrayList<String>> ultimateMedecine = new ArrayList<>();
		for (ReceiptGenaration element : chooseData) {
			MedicineEntryData medicine = medicineEntryService.get(element.getMedecineid());
			ArrayList<String> temp = new ArrayList<>();
			temp.add(medicine.getMedicineName());
			temp.add(medicine.getExpiryDate());
			temp.add(String.valueOf(medicine.getPrice()));
			temp.add(Integer.toString(element.getId()));
			ultimateMedecine.add(temp);

		}
		
		session.setAttribute("resultData", result);
		session.setAttribute("chooceMedicine", ultimateMedecine);
		return "billing";
	}

	@Transactional
	@RequestMapping("/insert/{id}")
	public String insertData(HttpServletRequest request, @PathVariable String id) {
		MedicineEntryData medicine = medicineEntryService.get(Integer.valueOf(id));
		ReceiptGenaration receipt = new ReceiptGenaration();
		receipt.setMedecineid(medicine.getId());
		receipt.setQuantity(medicine.getQuantity());
		receiptGenarationService.save(receipt);
		return "redirect:/SearchMedicine";
	}

	@Transactional
	@RequestMapping("/remove/{id}")
	public String removeData(HttpServletRequest request, @PathVariable String id) {
		receiptGenarationService.delete(Integer.valueOf(id));
		return "redirect:/SearchMedicine";
	}

}
