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
		issueTypeRepo.save(new IssueType("outdoor", "Sidewalk", "Debris in sidewalk", "Trash Collection"));
		issueTypeRepo.save(new IssueType("outdoor", "Sidewalk", "Damaged Crosswalk", "Road Repair"));
		issueTypeRepo.save(new IssueType("outdoor", "Sidewalk", "Missing Sidewalk", "City Planning"));
		issueTypeRepo.save(new IssueType("outdoor", "Building", "Entrance not accessable", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("outdoor", "Building", "Missing handrail", "Code Enforcement"));
		issueTypeRepo.save(new IssueType("indoor", "Building", "Inaccessable restroom", "Code Enforcement"));

	}

}
