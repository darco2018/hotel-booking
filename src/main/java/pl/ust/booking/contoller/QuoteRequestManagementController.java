package pl.ust.booking.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.ust.booking.model.QuoteRequest;

@Controller
public class QuoteRequestManagementController {

	@GetMapping(path = "/quoteRequests")
	public String listRequests() {

		return "quoteRequestsList";
	}

	@GetMapping(path = "/quoteRequests", params = "eventType=wedding")
	public String listWeddingRequests() {

		return "quoteRequestsList";
	}

	@GetMapping("/quoteRequests/{quoteId}")
	public String viewQuoteRequest(@PathVariable int quoteId) {

		return "quoteRequestDetails";
	}

	@PostMapping("/quoteDetail")
	public String updateQuoteRequest(@ModelAttribute QuoteRequest quoteform) {
		
		return "quoteRequestDetails";
	}
	
	

}
