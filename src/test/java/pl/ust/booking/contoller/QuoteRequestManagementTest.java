package pl.ust.booking.contoller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(QuoteRequestManagementController.class)
public class QuoteRequestManagementTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private QuoteRequestManagementController quoteRequestManagementController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldListWeddingQuoteRequests() throws Exception {
		mockMvc.perform(get("/quoteRequests")
				.param("eventType", "wedding")
				.accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk());		
	}
	
	@Test
	public void shouldGetQuoteRequestDetails() throws Exception {
		mockMvc.perform(get("/quoteRequests/2")
				.accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk());		
	}

}
