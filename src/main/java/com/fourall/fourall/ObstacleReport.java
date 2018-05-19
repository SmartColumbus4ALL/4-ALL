package com.fourall.fourall;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ObstacleReport {
	@Id
	@GeneratedValue
	private Long id;
	private double latitude;
	private double longitude;

	private String streetAddress = null;
	private String businessName = null;
	private LocalDate reportDate;
	@ManyToOne
	private IssueType issue;

	public ObstacleReport(double latitude, double longitude, LocalDate reportDate, IssueType issue) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.reportDate = reportDate;
		this.issue = issue;

	}

	public ObstacleReport(String businessName, String streetAddress, LocalDate reportDate, IssueType issue) {
		this.businessName = businessName;
		this.streetAddress = streetAddress;
		this.reportDate = reportDate;
		this.issue = issue;
		GeoData geoData = generateGeoData(businessName, streetAddress);
		latitude = geoData.getLatitude();
		longitude = geoData.getLongitude();
	}

	public ObstacleReport() {
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getBusinessName() {
		return businessName;
	}

	public LocalDate getReportDate() {
		return reportDate;
	}

	public IssueType getIssue() {
		return issue;
	}

	private GeoData generateGeoData(String businessName, String streetAddress) {
		// TODO fix this mock up
		return new GeoData(40.2594, -81.9641);
	}

	public class GeoData {
		private double latitude;
		private double longitude;

		public GeoData(double latitude, double longitude) {
			this.latitude = latitude;
			this.longitude = longitude;
		}

		public double getLatitude() {
			return latitude;
		}

		public double getLongitude() {
			return longitude;
		}
	}

	public Long getId() {
		return id;
	}

}
