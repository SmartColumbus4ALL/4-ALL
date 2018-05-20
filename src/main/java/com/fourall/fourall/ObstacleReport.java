package com.fourall.fourall;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;

@Entity
public class ObstacleReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double latitude;
	private double longitude;

	private String streetAddress = null;
	private LocalDate reportDate;
	@ManyToOne
	private IssueType issue;

	public ObstacleReport(double latitude, double longitude, String streetAddress, LocalDate reportDate,
			IssueType issue) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.reportDate = reportDate;
		this.issue = issue;
		// if (streetAddress != null || streetAddress == "") {
		// this.streetAddress = streetAddress;
		// GeoData geoData = generateGeoData(this.streetAddress);
		// this.latitude = geoData.getLatitude();
		// this.longitude = geoData.getLongitude();
		// }

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

	public String getDate() {
		return reportDate.toString();
	}

	public LocalDate getReportDate() {
		return reportDate;
	}

	public IssueType getIssue() {
		return issue;
	}

	private GeoData generateGeoData(String streetAddress) {

		RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);

		String API_KEY = "AIzaSyC1uGrPpwmqruklsD7EM0Fh5IvjxKZtCnY";
		String addressQuery = streetAddress.replaceAll("\\s", "+");
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + addressQuery + "&key=" + API_KEY;

		URI uri = UriComponentsBuilder.fromHttpUrl(url).build().encode().toUri();

		JsonNode jsonResponse;
		jsonResponse = restTemplate.getForObject(uri, JsonNode.class);
		JsonNode jsonDebug1 = jsonResponse.get("results").get(0);
		JsonNode jsonDebug2 = jsonDebug1.get("geometry");
		JsonNode jsonDebug3 = jsonDebug2.get("location");
		String latitude = jsonDebug3.get("lat").asText();

		String longitude = jsonResponse.get("results").get(0).get("geometry").get("location").get("lng").asText();
		return new GeoData(Double.parseDouble(latitude), Double.parseDouble(longitude));
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
