package com.ashokit.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.request.SerachRequest;

public interface ReportService {
	
	public List<String> getPlanName();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SerachRequest request);
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	
	public boolean exportPdf(HttpServletResponse response)throws Exception ;
	
	
}
