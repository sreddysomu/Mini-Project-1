package com.ashokit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.request.SerachRequest;
import com.ashokit.service.ReportService;


@Controller
public class ReportController {
	@Autowired
	private ReportService service;
	@PostMapping("/search")
	public String handleSearch( @ModelAttribute("search")SerachRequest search,Model model) {
		
		List<CitizenPlan> plans = service.search(search);
		model.addAttribute("plans",plans);
		init(model);
		
		return "index";
	}
	
	
	@GetMapping("/excel")
	public String exportExcel(@ModelAttribute("search")SerachRequest search,Model model,HttpServletResponse response) throws Exception{
	List<CitizenPlan> Plans = service.search(search);	
	model.addAttribute("plans", Plans);
	init(model);
	 
	return "index";
	}
	
	@GetMapping("/pdf")
	public String exportGenerate(@ModelAttribute("search")SerachRequest search,Model model,HttpServletResponse response) throws Exception{
		boolean status = service.exportPdf(response);
		init(model);
		if(status) {
			model.addAttribute("export","Pdf Exported");
		}else {
			model.addAttribute("export","Pdf not Exported");
		}
		return "index";
	}
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("search", new SerachRequest());

		init(model);
		
		return "index";
	}
	private void init(Model model) {
		//model.addAttribute("search", new SerachRequest());
		model.addAttribute("names", service.getPlanName());
		model.addAttribute("status", service.getPlanStatus());
		List<String> planStatus = service.getPlanStatus();
		model.addAttribute("status",planStatus);
		
	}
}
