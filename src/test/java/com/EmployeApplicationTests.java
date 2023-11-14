package com;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = EmployeApplication.class)
public class EmployeApplicationTests {

	public EmployeApplicationTests() {
		super();
	}

	@ParameterizedTest
	@Tag("Important")
	@DisplayName("Test")
	@CsvSource({"test"})
	public void fiscalCodeCalculatorServiceFailureTest(String str) throws Exception {
		Assert.assertTrue(true);
	}
	

}
