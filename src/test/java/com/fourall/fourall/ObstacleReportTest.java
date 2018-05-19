package com.fourall.fourall;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ObstacleReportTest {
	@Test
	public void shoudReturnCorrectGeolocaleForGivenAddress() {
		ObstacleReport underTest = new ObstacleReport("Fintech 71", "107 S High St #200, Columbus, OH 43215, USA", null,
				null);
		assertThat(underTest.getLatitude(), is(39.959946));
	}

}
