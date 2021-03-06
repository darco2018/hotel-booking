package pl.ust.booking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SmokeTest {
	
	@LocalServerPort
	private int port;
	
	private URL base;
	
	@Autowired
	private TestRestTemplate template;
	
	@Autowired
	private GreetingController greetingController;
	
	@Before
	public void setUp() throws MalformedURLException {
		this.base = new URL("http://localhost:" + port + "/greeting" );
    }
	

	@Test
	public void contextLoads() {
		assertThat(greetingController).isNotNull();
	}
	
	@Test
	public void getHello() throws Exception{
		ResponseEntity<String> response = template.getForEntity(this.base.toString(), String.class);
		assertThat(response.getBody(), containsString("Hello, World!"));
	}
	
	

}
