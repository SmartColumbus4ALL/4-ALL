package com.fourall.fourall;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IssuePopulator implements CommandLineRunner {
	@Resource
	IssueTypeRepository issueTypeRepo;

	@Override
	public void run(String... args) throws Exception {
		issueTypeRepo.save(new IssueType("outdoor", "sidewalk", "Debris in Sidewalk", "Trash Collection"));
		issueTypeRepo.save(new IssueType("outdoor", "sidewalk", "Damaged Crosswalk", "Road Repair"));
		issueTypeRepo.save(new IssueType("outdoor", "sidewalk", "Missing Sidewalk", "City Planning"));
		issueTypeRepo.save(new IssueType("outdoor", "sidewalk", "Other", "City Planning"));
		issueTypeRepo.save(new IssueType("outdoor", "ramp", "Entrance not Accessable", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "ramp", "Damaged", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "ramp", "No Ramp", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "ramp", "Other", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "handrail", "Missing Handrail", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "handrail", "Other", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "handrail", "Damaged", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "curb", "Other", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "curb", "Damaged", "Curb repair"));
		issueTypeRepo.save(new IssueType("outdoor", "curb", "No Curb", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "doors", "Damaged", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "doors", "Missing Handle", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "doors", "Handicap Switch", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "doors", "Other", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "handrail", "Missing", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "handrail", "Other", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "handrail", "Damaged", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "ramp", "Damaged", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "ramp", "Missing", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "ramp", "Other", "Code Enforcement"));

	}

}
