package com.fourall.fourall;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IssuePopulator implements CommandLineRunner {
	@Resource
	IssueTypeRepository issueTypeRepo;

	// TODO Make this idempotent
	@Override
	public void run(String... args) throws Exception {
		issueTypeRepo.save(new IssueType("outdoor", "sidewalk", "Debris in Sidewalk", "Trash Collection"));
		issueTypeRepo.save(new IssueType("outdoor", "sidewalk", "Damaged Crosswalk", "Road Repair"));
		issueTypeRepo.save(new IssueType("outdoor", "sidewalk", "Missing Sidewalk", "City Planning"));
		issueTypeRepo.save(new IssueType("outdoor", "sidewalk", "Other", "City Planning"));
		issueTypeRepo.save(new IssueType("outdoor", "ramp", "Entrance not Accessable", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "ramp", "Other", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "handrail", "Missing Handrail", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "handrail", "Other", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "door", "Broken Door", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "door", "Other", "Code Enforcement"));

	}

}
