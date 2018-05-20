package com.fourall.fourall;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObstacleReportController {
	@Resource
	IssueTypeRepository issueTypeRepo;

	@RequestMapping("/api/issues")
	public Iterable<IssueType> findIssueTypes() {
		return issueTypeRepo.findAll();
	}

	@RequestMapping("/api/issues/category/{category}")
	public Iterable<IssueType> findIssueTypesByCategory(@PathVariable(name = "category") String issueCategory) {

		return issueTypeRepo.findAllByIssueCategory(issueCategory);

	}

	@RequestMapping("/api/issues/categories")
	public Set<String> retrieveIssueCategories() {
		Set<String> issueCategories = new HashSet<String>();
		for (IssueType issue : issueTypeRepo.findAll()) {
			issueCategories.add(issue.getIssueCategory());
		}
		return issueCategories;
	}

}
