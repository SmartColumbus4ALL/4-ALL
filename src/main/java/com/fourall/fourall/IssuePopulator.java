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
		issueTypeRepo.save(new IssueType("outdoor", "ramp", "damaged", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "ramp", "no ramp", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "ramp", "other", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "handrail", "Missing Handrail", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "handrail", "Other", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "handrail", "damaged", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "curb", "Other", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "curb", "damaged", "Curb repair"));
		issueTypeRepo.save(new IssueType("outdoor", "curb", "no curb", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outoor", "doors", "damaged", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outoor", "doors", "missing handle", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outoor", "doors", "handicap switch", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outoor", "doors", "Other", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "handrail", "missing", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "handrail", "Other", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "haindrail", "damaged", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "ramp", "damaged", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "ramp", "missing", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "ramp", "Other", "Code Enforcement"));



	}

}
