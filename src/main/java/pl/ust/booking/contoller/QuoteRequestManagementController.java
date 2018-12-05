package pl.ust.booking.contoller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//----------------MODEL METHODS----------------
	@ModelAttribute
	public void addCOmmonAttributes(@RequestParam String eventType, Model model) {
		String customMessage = "You are viewing requests for " + eventType;
		model.addAttribute("eventTypeMessage", customMessage);
	}
	//---- BINDER METHODS  - register controller-specific object conversion or formatting
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		// when user enters wrong date format, we''ll get IllegalArgumentException,
		// Failed to convert property value of type String to java.util.Date. Could not parse ...
	}
	
	// --------- CONTROLLER ADVICE -apply @InitBinder, @ModelAttribute globally, across many controllers
	// can be fine tuned to apply only to certain types of controllers, only @RestControllers,
	//or to certain packages, or a specific controller

}
