package pl.ust.booking.contoller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import pl.ust.booking.model.QuoteRequest;

@RunWith(SpringRunner.class)
@WebMvcTest(QuoteRequestController.class)
public class QuoteRequestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private QuoteRequestController quoteRequestController;
	
	@Before //each
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldGetQuoteForm() throws Exception {
		
		mockMvc.perform(get("/newquote"))
		.andExpect(status().is(200))
		.andReturn();		
	}
	@Test
	public void shouldSubmitQuoteForm() throws Exception {
		
		QuoteRequest quoteRequest = new QuoteRequest();
		
		mockMvc.perform(post("/newquote", quoteRequest))
		.andExpect(status().is(200)) // 201 ?
		.andReturn();		
	}
	
	

}
