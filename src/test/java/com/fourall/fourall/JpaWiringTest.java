package com.fourall.fourall;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JpaWiringTest {
	@Resource
	private TestEntityManager entityManager;
	@Resource
	private IssueTypeRepository issueTypeRepo;
	@Resource
	private ObstacleReportRepository obstacleReportRepo;

	IssueType testIssueType = new IssueType("Test Catergory", "Test", "Mock");

	@Before
	public void setup() {
		testIssueType = issueTypeRepo.save(testIssueType);
	}

	@Test
	public void shouldSaveAndLoadIssueType() {
		Long testIssueTypeId = testIssueType.getId();
		entityManager.flush(); // forces pending stuff to happen?
		entityManager.clear();
		IssueType retrievedType = issueTypeRepo.findOne(testIssueTypeId);
		assertThat(testIssueType.getReportRecipient(), is(retrievedType.getReportRecipient()));
	}

	@Test
	public void shouldSaveAndLoadObstacleReport() {
		ObstacleReport testReport = new ObstacleReport(42.0, 42.0, null, null, testIssueType);
		testReport = obstacleReportRepo.save(testReport);
		Long testReportId = testReport.getId();
		entityManager.flush(); // forces pending stuff to happen?
		entityManager.clear();
		testReport = obstacleReportRepo.findOne(testReportId);
		assertThat(testReport.getIssue(), is(testIssueType));

	}

}
