package pl.ust.booking.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuoteRequestController {
	
	@GetMapping //("/newquote")
	public String getQuoteForm() {
		
		return "newQuote";		
	}
	
	@PostMapping //("/newquote")
	public String submitQuoteForm() {
		
		return "newQuoteConfirmation";		
	}

}
