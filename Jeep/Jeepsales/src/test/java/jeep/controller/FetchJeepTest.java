package jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;

import entity.Jeep;
import entity.jeepModel;
import io.swagger.v3.oas.models.PathItem.HttpMethod;
import jeep.controller.support.FetchTestJeep;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
		"classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
config = @SqlConfig(encoding = "utf-8"))

class FetchJeepTest extends FetchTestJeep{
	 // @Autowired
	//  private TestRestTemplate restTemplate;
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	
	@Test
	void testDb() {
	int numrows = JdbcTestUtils.countRowsInTable(jdbctemplate, "customers");
	System.out.println("num=" + numrows);
		

	}
	@Disabled
	  @Test
	void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
jeepModel model = jeepModel.WRANGLER;
	String trim = "Sport";
	String URI = String.format("%s?model=%s&trim=%s", getBaseURI(), model, trim);
	

	ResponseEntity<List<Jeep>> response = 
	getRestTemplate().exchange(URI, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
	
	
	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	
	
	List<Jeep> expected = buildExpected();
	assertThat(response.getBody()).isEqualTo(expected);	}


	}


	

	
	

	
	
	


