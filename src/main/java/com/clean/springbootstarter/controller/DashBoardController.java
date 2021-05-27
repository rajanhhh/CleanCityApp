package com.clean.springbootstarter.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.clean.springbootstarter.beans.Complaint;
import com.clean.springbootstarter.beans.Complaint;

@Controller
public class DashBoardController {

	@Autowired
	com.clean.springbootstarter.services.cleanCityService cleanCityService;

	@RequestMapping("/cleancity")
	public String index() {
		return "Welcome to clean city portal !";

	}

	@GetMapping("/reportBoard")
	public String reportBoard() {
		return "ReportingBoard";

	}
	
	@GetMapping("/fetch")
	public String fetchBoard() {
		return "cleanCityInfo";
	}
	
	@GetMapping("/ticketBoard")
	public String ticketBoard() {
		return "TicketBoard";

	}
	
	@PostMapping("/ticketBoard")
	public String getTicketStatus(String ticketId, Model model) {
		String status = cleanCityService.getTicketStatus(ticketId);
		if(status!=null) {
			if(status.equalsIgnoreCase("A")) {
				status= "Your ticket has been acknowledged successfully. Prompt action will be taken as soon as possible. Thank you!!";
			}
			else if(status.equalsIgnoreCase("D")) {
				status= "Your ticket has been closed successfully.Enjoy the cleanliness!!";
			}
			else if(status.equalsIgnoreCase("P")) {
				status= "Your ticket will be acknowledged as soon as our manpower is ready. It has not been acknowledged yet.";
			}
			else {
				status= "Something went wrong. We could not fetch the status of your ticket. Please try again after sometime.";
			}
		}
		else {
			status= "Something went wrong. We could not fetch the status of your ticket. Please try again after sometime.";
		}
		model.addAttribute("status", status);

		return "TicketResult";

	}

	@PostMapping("/reportBoard")
	public String uploadForm(Complaint form, @RequestParam("image") MultipartFile file, Model model) {
		String status = "";
		FileInputStream fin  = null;

		try {
			if(null!=file){
			 fin = (FileInputStream) file.getInputStream();
			 
			}
			// FileInputStream fin = new
			// FileInputStream("/home/bhruguraj/Pictures/test.png");
			// System.out.println(fin);
			//Complaint complaint = new Complaint(form.getName(), form.getAddress(), form.getPin(), form.getPhone_number(),fin);
			Complaint complaint = new Complaint(0, form.getType(), form.getName(), form.getAddress(),
				form.getPin(), form.getPhone_number(), fin, form.getLongitude(), form.getLatitude());

			if (cleanCityService.insertComplaint(complaint) == 1) {

				status = "Your ticket has been logged sucessfully!!";
			} else {
				status = "Ticket logging failed due to technical issues. Please try again after sometime.";
			}
			model.addAttribute("ticketId", cleanCityService.getTicketID());
			model.addAttribute("status", status);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "ReportingResult";

	}

	@GetMapping("/fetch/data")
	@ResponseBody
	public String fetchData(@RequestParam("pin") String pin,@RequestParam("start_date")String start_date,@RequestParam("end_date")String end_date) {

		//ModelAndView map = new ModelAndView();
		String jsonStr = "";
		try {

			List<Complaint> complaints = cleanCityService.fetchComplaintByPin(pin,start_date,end_date);
			ObjectMapper Obj = new ObjectMapper();
			jsonStr = Obj.writeValueAsString(complaints);

			//map.addObject("responseText", jsonStr);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonStr;

	}
	
	/**
	 * Demo Page to show image retrieve and display in Browser.
	 * @param pin
	 * @return
	 */

	@GetMapping("/fetch/demo")
	public ModelAndView fetchDemo(@RequestParam("pin") String pin,@RequestParam("start_date")String start_date,@RequestParam("end_date")String end_date) {

		ModelAndView model = new ModelAndView("cleanCityInfo");
		try {

			List<Complaint> complaints = cleanCityService.fetchComplaintWithImage(pin,start_date,end_date);
			// ObjectMapper Obj = new ObjectMapper();
			// String jsonStr = Obj.writeValueAsString(userEntries);
			model.addObject("name", complaints.get(0).getName());
			model.addObject("address", complaints.get(0).getAddress());
			model.addObject("phone", complaints.get(0).getPhone_number());
			model.addObject("pin", complaints.get(0).getPin());
			model.addObject("ComplaintSubmissionDate", complaints.get(0).getComplaintSubmissionDate());
			// model.addAttribute("photo", jsonStr);
			if(null!=complaints.get(0).getPhoto()) {
			InputStream inputStream = complaints.get(0).getPhoto();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			byte[] imageBytes = outputStream.toByteArray();

			String base64Image = Base64.getEncoder().encodeToString(imageBytes);

			inputStream.close();
			outputStream.close();

			model.addObject("photo", base64Image);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;

	}
	
	@RequestMapping("/reportMap")
	public String report(Model model) {
		return "reportMap";
	} 

	/*@RequestMapping("/getComplaintList")
	@ResponseBody
	public String getComplaintList() {
		List<Complaint> complaints =cleanCityService.getAllComplaintsWithoutImage();
		ObjectMapper Obj = new ObjectMapper(); 
		String jsonStr=null;
		try {
			jsonStr = Obj.writeValueAsString(complaints);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonStr;
	} */

}
