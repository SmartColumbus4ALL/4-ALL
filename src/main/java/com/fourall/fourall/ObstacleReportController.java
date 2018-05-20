package com.fourall.fourall;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class ObstacleReportController {
	@Resource
	IssueTypeRepository issueTypeRepo;
	@Resource
	ObstacleReportRepository obstacleReportRepo;

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

	@PostMapping(path = "/api/report", consumes = "application/json", produces = "application/json")
	public void createReport(@RequestBody JsonNode jsonReport) {
		double lat = jsonReport.get("latitude").asDouble();
		double lng = jsonReport.get("longitude").asDouble();
		String address = jsonReport.get("streetAddress").asText();
		Long issueId = jsonReport.get("issueId").asLong();

		IssueType reportIssue = issueTypeRepo.findOne(issueId);

		ObstacleReport createdReport = new ObstacleReport(lat, lng, address, LocalDate.now(), reportIssue);
		obstacleReportRepo.save(createdReport);

	}
}
