
package com.ashokit.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.repository.CitizenPlanRepository;
import com.ashokit.request.SerachRequest;
import com.ashokit.utile.EmailUtils;
import com.ashokit.utile.ExcelGenerator;
import com.ashokit.utile.PdfGenerator;

@Component
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository planRepo;

	@Autowired
	private ExcelGenerator excelGenerator;

	@Autowired
	private EmailUtils emailutils;

	@Autowired
	private PdfGenerator pdfGenerator;

	
	public List<String> getPlanName() {

		return planRepo.getPlanName();

	}

	public List<String> getPlanStatus() {
		return planRepo.getPlanStatus();

	}

	public List<CitizenPlan> search(SerachRequest request) {
		CitizenPlan entity = new CitizenPlan();
		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		return planRepo.findAll(Example.of(entity));
	}

	
	
	public boolean exportPdf(HttpServletResponse Response) throws Exception {
		File f=new File("Plans.Pdf");
    List<CitizenPlan> Plans = planRepo.findAll();
    FileOutputStream fos = new FileOutputStream(f);
    pdfGenerator.generatePDF(Plans,fos);
		
		return true;
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		
		List<CitizenPlan> plans = planRepo.findAll();
		excelGenerator.generate(response, plans);
		File f = new File("Plans.xls");
		String subject = "Test mail subject";
		String body = "<h1> test mail body</h1>";
		String to = "sreddysomu9@gmail.com";
		emailutils.sendEmail(subject, body, to, f);

		f.delete();

		return true;

		
		
		
	}

	
	}
