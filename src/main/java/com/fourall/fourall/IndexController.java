package com.fourall.fourall;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@Resource
	ObstacleReportRepository obstacleReportRepo;
	@Resource
	IssueTypeRepository issueTypeRepo;

	@RequestMapping("/reports")
	public String displayAllReports(Model model) {
		Iterable<ObstacleReport> allReports = obstacleReportRepo.findAll();
		model.addAttribute("reports", allReports);
		return "all-reports";

	}

	// @RequestMapping("/")
	// public String displayIndex() {
	// return "/index.html";
	// }
}
