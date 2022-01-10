package com.mindex.challenge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void johnLennonFourReports(){

		ReportingStructure jLen = new ReportingStructure("16a596ae-edd3-4847-99fe-c4518e82c86f");
		int expectedJLenReports = 4;
		int actualJLenReports = jLen.getNumberOfReports();
		assertThat(actualJLenReports).isEqualTo(expectedJLenReports);

	}

}
