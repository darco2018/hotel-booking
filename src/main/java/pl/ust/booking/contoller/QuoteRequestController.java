package pl.ust.booking.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pl.ust.booking.model.QuoteRequest;

@Controller
public class QuoteRequestController {
	
	@GetMapping("/newquote")
	public String getQuoteForm(Model model) {
		
		model.addAttribute("quoteRequestForm", new QuoteRequest());
		
		
		return "newQuote";		
	}
	
	@PostMapping ("/newquote")
	public String submitQuoteForm() {
		
		return "newQuoteConfirmation";		
	}

}
