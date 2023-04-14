package com.ashokit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.repository.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private CitizenPlanRepository repo;
	
	@Override
	public void run(ApplicationArguments args)throws Exception{
		
		
		//cash plan data

				CitizenPlan c1 = new CitizenPlan();

				c1.setCitizenName("John");
				c1.setGender("Male");
				c1.setPlanName("Cash");
				c1.setPlanStatus("Approved");
				c1.setPlanStartDate(LocalDate.now());
				c1.setPlanEndDate(LocalDate.now().plusMonths(6));
				c1.setBenefitAmt(5000.00);


				CitizenPlan c2= new CitizenPlan();
				c2.setCitizenName("Smit");
				c2.setGender("Male");
				c2.setPlanName("Cash");
				c2.setPlanStatus("Denied");
				c2.setDenialReason("Rental Income");

				CitizenPlan c3 = new CitizenPlan();
				c3.setCitizenName("Cathy");
				c3.setGender("FeMale");
				c3.setPlanName("Cash");
				c3.setPlanStatus("Terminated");
				c3.setPlanStartDate(LocalDate.now().minusMonths(3));
				c3.setPlanEndDate(LocalDate.now().plusMonths(6));
				c3.setBenefitAmt(5000.0);
				c3.setTerminatedDate(LocalDate.now());
				c3.setTerminationRsn("Employed");

				//Food plan data

				CitizenPlan c4 = new CitizenPlan();

				c4.setCitizenName("David");
				c4.setGender("Male");
				c4.setPlanName("food");
				c4.setPlanStatus("Approved");
				c4.setPlanStartDate(LocalDate.now());
				c4.setPlanEndDate(LocalDate.now().plusMonths(6));
				c4.setBenefitAmt(3000.00);

				CitizenPlan c5 = new CitizenPlan();
				c5.setCitizenName("Robert");
				c5.setGender("Male");
				c5.setPlanName("food");
				c5.setPlanStatus("Denied");
				c5.setDenialReason("Property Income");

				CitizenPlan c6 = new CitizenPlan();
				c6.setCitizenName("Orlen");
				c6.setGender("FeMale");
				c6.setPlanName("food");
				c6.setPlanStatus("Terminated");
				c6.setPlanStartDate(LocalDate.now().minusMonths(2));
				c6.setPlanEndDate(LocalDate.now().plusMonths(6));
				c6.setBenefitAmt(6000.0);
				c6.setTerminatedDate(LocalDate.now());
				c6.setTerminationRsn("Employed");


				//medical plan data

				CitizenPlan c7 = new CitizenPlan();

				c7.setCitizenName("Carles");
				c7.setGender("Male");
				c7.setPlanName("medical");
				c7.setPlanStatus("Approved");
				c7.setPlanStartDate(LocalDate.now());
				c7.setPlanEndDate(LocalDate.now().plusMonths(6));
				c7.setBenefitAmt(6000.00);

				CitizenPlan c8 = new CitizenPlan();
				c8.setCitizenName("Butter");
				c8.setGender("Male");
				c8.setPlanName("medical");
				c8.setPlanStatus("Denied");
				c8.setDenialReason("Property Income");

				CitizenPlan c9 = new CitizenPlan();
				c9.setCitizenName("Orlen");
				c9.setGender("FeMale");
				c9.setPlanName("medical");
				c9.setPlanStatus("Terminated");
				c9.setPlanStartDate(LocalDate.now().minusMonths(3));
				c9.setPlanEndDate(LocalDate.now().plusMonths(6));
				c9.setBenefitAmt(2000.0);
				c9.setTerminatedDate(LocalDate.now());
				c9.setTerminationRsn("Gov job");


				//employment plan data
				CitizenPlan c10 = new CitizenPlan();

				c10.setCitizenName("Steve");
				c10.setGender("Male");
				c10.setPlanName("employment");
				c10.setPlanStatus("Approved");
				c10.setPlanStartDate(LocalDate.now());
				c10.setPlanEndDate(LocalDate.now().plusMonths(6));
				c10.setBenefitAmt(7000.00);

				CitizenPlan c11 = new CitizenPlan();
				c11.setCitizenName("Moris");
				c11.setGender("Male");
				c11.setPlanName("employment");
				c11.setPlanStatus("Denied");
				c11.setDenialReason("Property Income");

				CitizenPlan c12 = new CitizenPlan();
				c12.setCitizenName("Gibs");
				c12.setGender("FeMale");
				c12.setPlanName("medical");
				c12.setPlanStatus("Terminated");
				c12.setPlanStartDate(LocalDate.now().minusMonths(2));
				c12.setPlanEndDate(LocalDate.now().plusMonths(6));
				c12.setBenefitAmt(5000.0);
				c12.setTerminatedDate(LocalDate.now());
				c12.setTerminationRsn("Gov job");





			List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);

			repo.saveAll(list);
			

			}






		

	}


