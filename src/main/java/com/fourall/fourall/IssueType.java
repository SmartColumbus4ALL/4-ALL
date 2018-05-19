package com.fourall.fourall;

public class IssueType {

	private String typeOfIssue;
	private String reportRecipient;

	public IssueType(String typeOfIssue, String reportRecipient) {
		this.typeOfIssue = typeOfIssue;
		this.reportRecipient = reportRecipient;

	}

	public String getTypeOfIssue() {
		return typeOfIssue;
	}

	public String getReportRecipient() {
		return reportRecipient;
	}

}
