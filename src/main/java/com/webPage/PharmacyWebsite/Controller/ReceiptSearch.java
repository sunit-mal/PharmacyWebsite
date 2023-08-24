package com.webPage.PharmacyWebsite.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webPage.PharmacyWebsite.Model.InvoiceData;
import com.webPage.PharmacyWebsite.Service.InvoiceService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ReceiptSearch {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@RequestMapping("/customerSearch")
	public String Result(HttpServletRequest request, HttpSession session){
		ArrayList<ArrayList<String>> dataPassList = new ArrayList<>();
		String searchKeyString = request.getParameter("searchKey");
		String typeString = request.getParameter("searchType");
		if (typeString.equals("name")) {
			dataPassList = searchByName(searchKeyString);
		}
		if(typeString.equals("date")) {
			dataPassList = searchByvisitDate(searchKeyString);
		}
		if(typeString.equals("uuid")) {
			dataPassList = searchByuuid(searchKeyString);
		}
		session.setAttribute("CustomerInvoice", dataPassList);
		return "invoiceCheck";
	}
	
	public ArrayList<ArrayList<String>> searchByName(String searchKey) {
		List<InvoiceData> allDatas = invoiceService.getInvoicedata();
		ArrayList<ArrayList<String>> dataPassList = new ArrayList<>();
		for (InvoiceData data : allDatas) {
			if (data.nameMatch(searchKey)) {
				ArrayList<String> tempArrayList = new ArrayList<>();
				tempArrayList.add(data.getCustomerName());
				tempArrayList.add(data.getContectNumber());
				tempArrayList.add(data.getVisitDate());
				tempArrayList.add(data.getUuid());		
				dataPassList.add(tempArrayList);
			}
		}
		
		return dataPassList;
	}
	
	public ArrayList<ArrayList<String>> searchByvisitDate(String searchKey) {
		List<InvoiceData> allDatas = invoiceService.getInvoicedata();
		ArrayList<ArrayList<String>> dataPassList = new ArrayList<>();
		for (InvoiceData data : allDatas) {
			if (data.dateCheck(searchKey)) {
				ArrayList<String> tempArrayList = new ArrayList<>();
				tempArrayList.add(data.getCustomerName());
				tempArrayList.add(data.getContectNumber());
				tempArrayList.add(data.getVisitDate());
				tempArrayList.add(data.getUuid());		
				dataPassList.add(tempArrayList);
			}
		}
		
		return dataPassList;
	}

	public ArrayList<ArrayList<String>> searchByuuid(String searchKey) {
		List<InvoiceData> allDatas = invoiceService.getInvoicedata();
		ArrayList<ArrayList<String>> dataPassList = new ArrayList<>();
		for (InvoiceData data : allDatas) {
			if (data.uuidMatch(searchKey)) {
				ArrayList<String> tempArrayList = new ArrayList<>();
				tempArrayList.add(data.getCustomerName());
				tempArrayList.add(data.getContectNumber());
				tempArrayList.add(data.getVisitDate());
				tempArrayList.add(data.getUuid());		
				dataPassList.add(tempArrayList);
			}
		}
		
		return dataPassList;
	}
}
