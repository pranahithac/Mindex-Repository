package com.mindex.challenge.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceImplTest {

	private String compensationUrl;
    private String employeeIdCompensationUrl;

    @Autowired
    private CompensationService compensationService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
    	compensationUrl = "http://localhost:" + port + "/compensation";
    	employeeIdCompensationUrl = "http://localhost:" + port + "/compensation/{id}";
    }

    @Test
    public void testCreateReadUpdate() {
        Compensation compensation_test = new Compensation();
        compensation_test.setEmployeeId("12345");
        compensation_test.setSalary(1222.0);
        compensation_test.setEffectiveDate(null);

        // Create checks
        Compensation InsertCompensation = restTemplate.postForEntity(compensationUrl, compensation_test, Compensation.class).getBody();
        assertNotNull(InsertCompensation.getEmployeeId());
        assertCompensation(compensation_test, InsertCompensation);

        // Read checks
        Compensation GenerateCompensation = restTemplate.getForEntity(employeeIdCompensationUrl,Compensation.class,InsertCompensation.getEmployeeId() ).getBody();
       
        assertEquals(InsertCompensation.getEmployeeId(), GenerateCompensation.getEmployeeId());
        assertCompensation(InsertCompensation, GenerateCompensation);

}
    private static void assertCompensation(Compensation expected, Compensation actual) {
    	assertEquals(expected.getEmployeeId(), actual.getEmployeeId());  
    	assertEquals(expected.getEffectiveDate(), actual.getEffectiveDate());  
    }
}
