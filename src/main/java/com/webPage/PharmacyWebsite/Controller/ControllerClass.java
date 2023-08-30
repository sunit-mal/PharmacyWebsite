package com.webPage.PharmacyWebsite.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webPage.PharmacyWebsite.Model.InvoiceData;
import com.webPage.PharmacyWebsite.Model.MedicineEntryData;
import com.webPage.PharmacyWebsite.Model.ReceiptGenaration;
import com.webPage.PharmacyWebsite.Model.notification;
import com.webPage.PharmacyWebsite.Service.InvoiceService;
import com.webPage.PharmacyWebsite.Service.MedicineEntryService;
import com.webPage.PharmacyWebsite.Service.ReceiptGenarationService;
import com.webPage.PharmacyWebsite.Service.notificationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class ControllerClass {
	@Autowired
	private MedicineEntryService medicineEntryService;

	@Autowired
	private ReceiptGenarationService receiptGenarationService;

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private notificationService notificationService;

	@RequestMapping("/")
	public String index(HttpServletRequest request, HttpSession session) {
		getNotification(request, session);
		session.setAttribute("massage", "");
		return "index";
	}

	@RequestMapping("/entry")
	public String medicineEntry(HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/loginPage";
		}
		return "medicineentry";
	}

	@RequestMapping("/billing")
	@Transactional
	public String billing(HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/loginPage";
		}

		receiptGenarationService.removeAll();
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

	@RequestMapping("/medicinecheck")
	public String medicinecheck(HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/loginPage";
		}

		ArrayList<ArrayList<String>> result = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();
		temp.add("");
		temp.add("");
		temp.add("");
		temp.add("");
		result.add(temp);

		session.setAttribute("resultData", result);

		return "medicineCheck";
	}

	@RequestMapping("/signupPage")
	public String signupPage(HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("user") != null) {
			return "redirect:/";
		}
		return "signup";
	}

	@RequestMapping("/loginPage")
	public String loginPage(HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("user") != null) {
			return "redirect:/";
		}
		return "login";
	}

	@RequestMapping("/invoice")
	public String invoice(HttpServletRequest request) {
		return "Invoice";
	}

	@RequestMapping("/invoiceCheck")
	public String invoiceCheck(HttpServletRequest request, HttpSession session) {

		if (session.getAttribute("user") == null) {
			return "redirect:/loginPage";
		}
		List<InvoiceData> allDatas = invoiceService.getInvoicedata();
		ArrayList<ArrayList<String>> dataPassList = new ArrayList<>();
		for (InvoiceData data : allDatas) {
			ArrayList<String> tempArrayList = new ArrayList<>();
			tempArrayList.add(data.getCustomerName());
			tempArrayList.add(data.getContectNumber());
			tempArrayList.add(data.getVisitDate());
			tempArrayList.add(data.getUuid());
			dataPassList.add(tempArrayList);
		}
		session.setAttribute("CustomerInvoice", dataPassList);
		return "invoiceCheck";
	}

	public void getNotification(HttpServletRequest request, HttpSession session) {
		List<notification> allNotifications = notificationService.getList();
		ArrayList<ArrayList<String>> allNotification = new ArrayList<>();
		if (allNotifications.isEmpty()) {
			ArrayList<String> tempArrayList = new ArrayList<>();
			String massage = " ";
			tempArrayList.add(massage);
			allNotification.add(tempArrayList);
		} else {
			for (notification arrayList : allNotifications) {
				ArrayList<String> tempArrayList = new ArrayList<>();
				String massage = "Your Madicine " + arrayList.getMedicineName() + " is out of stock";
				tempArrayList.add(massage);
				tempArrayList.add(Integer.toString(arrayList.getId()));
				allNotification.add(tempArrayList);
			}
		}
		session.setAttribute("notifications", allNotification);
		session.setAttribute("notficationCount", allNotifications.size());
	}
	
	@Transactional
	@RequestMapping("/makeAsRead/{id}")
	public String makeNotificationAsRead(HttpServletRequest request, HttpSession session, @PathVariable String id) {
		notificationService.delete(Integer.valueOf(id));
		return "redirect:/";
	}
}
