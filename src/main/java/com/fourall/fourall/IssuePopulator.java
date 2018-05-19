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
		issueTypeRepo.save(new IssueType("Debris in sidewalk", "Trash Collection"));
		issueTypeRepo.save(new IssueType("Damaged Crosswalk", "Road Repair"));
		issueTypeRepo.save(new IssueType("Missing Sidewalk", "City Planning"));
		issueTypeRepo.save(new IssueType("Entrance not accessable", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("Missing handrail", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("Inaccessable restroom", "Code Enforcement"));

	}

}
