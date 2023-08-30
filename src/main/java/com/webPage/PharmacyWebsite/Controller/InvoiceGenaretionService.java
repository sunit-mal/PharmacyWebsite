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
import com.webPage.PharmacyWebsite.Model.SellMedicine;
import com.webPage.PharmacyWebsite.Model.notification;
import com.webPage.PharmacyWebsite.Service.InvoiceService;
import com.webPage.PharmacyWebsite.Service.MedicineEntryService;
import com.webPage.PharmacyWebsite.Service.ReceiptGenarationService;
import com.webPage.PharmacyWebsite.Service.notificationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class InvoiceGenaretionService {
	@Autowired
	private InvoiceService is;

	@Autowired
	private MedicineEntryService medicineEntryService;

	@Autowired
	private ReceiptGenarationService receiptGenarationService;

	@Autowired
	private notificationService notificationService;
	
	@RequestMapping("/invoiceGen")
	public String invoiceGen(HttpServletRequest request, HttpSession session) {

		List<ReceiptGenaration> chooseData = receiptGenarationService.getList();
		ArrayList<ArrayList<String>> ultimateMedecine = new ArrayList<>();
		for (ReceiptGenaration element : chooseData) {
			MedicineEntryData medicine = medicineEntryService.get(element.getMedecineid());
			ArrayList<String> temp = new ArrayList<>();
			temp.add(medicine.getMedicineName());
			temp.add(medicine.getExpiryDate());
			temp.add(Long.toString(element.getQuantity()));
			temp.add(String.valueOf(medicine.getPrice()));
			temp.add(String.valueOf(element.getMedecineid()));
			ultimateMedecine.add(temp);

		}
		session.setAttribute("invoice", ultimateMedecine);

		return "invoicedata";
	}

	@Transactional
	@RequestMapping("/saveInvoice")
	public String invoiceSave(HttpServletRequest request, HttpSession session) {

		int count = Integer.valueOf(request.getParameter("count"));
		InvoiceData invoiceData = new InvoiceData();
		invoiceData.setCustomerName(request.getParameter("CustomerName"));
		invoiceData.setContectNumber(request.getParameter("number"));
		invoiceData.setVisitDate(request.getParameter("visitDate"));
		String uuid = invoiceData.genUUID();
		invoiceData.setUuid(uuid);
		float total = 0;
		for (int i = 0; i < count; i++) {
			SellMedicine medicine = new SellMedicine();
			medicine.setUuid(uuid);
			medicine.setMedicineName(request.getParameter("medName" + i));
			medicine.setExpiryDate(request.getParameter("expiryDate" + i));
			medicine.setQuantity(request.getParameter("quantity" + i));
			medicine.setPrice(request.getParameter("price" + i));
			total += Float.valueOf(request.getParameter("price" + i));
			int medID = Integer.valueOf(request.getParameter("medid" + i));
			int quantity = Integer.valueOf(request.getParameter("quantity" + i));
			updateNew(medID, quantity);
			is.saveMedicineList(medicine);
		}
		invoiceData.setTotalprice(total);
		is.saveInvoiceData(invoiceData);
		return "redirect:/fetchInvoice/" + uuid;
	}

	@RequestMapping("/fetchInvoice/{uuid}")
	public String fetchInvoice(HttpServletRequest request, HttpSession session, @PathVariable String uuid) {
		List<InvoiceData> listInvoice = is.getInvoicedata();
		List<SellMedicine> listmed = is.getMedicineList();
		ArrayList<String> list = new ArrayList<>();
		for (InvoiceData element : listInvoice) {
			if (element.uuidMatch(uuid)) {
				list.add(element.getCustomerName());
				list.add(element.getVisitDate());
				list.add(element.getContectNumber());
				list.add(element.getUuid());
				list.add(Float.toString(element.getTotalprice()));
			}
		}
		ArrayList<ArrayList<String>> meds = new ArrayList<>();
		for (SellMedicine element : listmed) {
			if (element.FindByUUID(uuid)) {
				ArrayList<String> temp = new ArrayList<>();
				temp.add(element.getMedicineName());
				temp.add(element.getExpiryDate());
				temp.add(element.getQuantity());
				temp.add(element.getPrice());
				meds.add(temp);
			}
		}

		session.setAttribute("invoiceCustomer", list);
		session.setAttribute("issueMeds", meds);
		return "redirect:/invoice";
	}

	public void updateNew(int id, int quantity) {
		MedicineEntryData objData = medicineEntryService.get(id);
		MedicineEntryData newdata = new MedicineEntryData();
		if (objData.getQuantity() - quantity <= 0) {
			notification notify = new notification();
			notify.setMedicineName(objData.getMedicineName());
			notificationService.save(notify);
			medicineEntryService.delete(id);
			
		} else {

			newdata.setMedicineName(objData.getMedicineName());
			newdata.setEntryDate(objData.getEntryDate());
			newdata.setExpiryDate(objData.getExpiryDate());
			newdata.setPrice(objData.getPrice());
			newdata.setQuantity(objData.getQuantity() - quantity);
			medicineEntryService.update(id, newdata);
		}
	}
}
