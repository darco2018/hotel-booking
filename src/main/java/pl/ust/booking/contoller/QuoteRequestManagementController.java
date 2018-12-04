package pl.ust.booking.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView viewQuoteRequest(@PathVariable int quoteId) {
		
		QuoteRequest quoteRequest = new QuoteRequest(); // it would normally be returned by service
		quoteRequest.setBudget(5000);
		quoteRequest.setEventType("wedding");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("quoteRequest", quoteRequest);
		mav.setViewName("quoteRequestDetails");
		
		return mav;
	}
	
	@GetMapping("/quoteRequest/social/{id}")
	public String viewRequestSocial(@PathVariable int id) {
		
		String returnViewName = "quoteRequestSocialEventDetail";
		
		boolean someCondition = true;
		if(someCondition) {
			returnViewName = "redirect:/quoteRequest/wedding/{id}"; // go to different controller
		}
		
		return returnViewName;
	}
	
	@GetMapping
	@ResponseBody
	public QuoteRequest viewQuoteRequestApi() {  //should be somewhere else in fact
		
		QuoteRequest quoteRequest = new QuoteRequest(); // it would normally be returned by service
		quoteRequest.setBudget(5000);
		
		return quoteRequest; // conversion to JSON
	}

	@PostMapping("/quoteDetail")
	public String updateQuoteRequest(@ModelAttribute QuoteRequest quoteform) {
		
		return "quoteRequestDetails";
	}
	
	

}
