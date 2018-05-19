package com.fourall.fourall;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class IssueType {
	@Id
	@GeneratedValue
	private Long id;
	private String typeOfIssue;
	private String reportRecipient;
	@OneToMany(mappedBy = "issue")
	private Collection<ObstacleReport> obstacleReports;

	public Collection<ObstacleReport> getObstacleReports() {
		return obstacleReports;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IssueType other = (IssueType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public IssueType(String typeOfIssue, String reportRecipient) {
		this.typeOfIssue = typeOfIssue;
		this.reportRecipient = reportRecipient;

	}

	public IssueType() {
	}

	public String getTypeOfIssue() {
		return typeOfIssue;
	}

	public String getReportRecipient() {
		return reportRecipient;
	}

	public Long getId() {
		return id;
	}

}
