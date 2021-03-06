package pl.ust.booking;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import pl.ust.booking.contoller.QuoteRequestController;
import pl.ust.booking.contoller.QuoteRequestManagementController;

// data formatting is consistent for both user roles: customer and sales rep
@ControllerAdvice(assignableTypes = {
		QuoteRequestController.class,
		QuoteRequestManagementController.class
})
public class QuoteControllerRequestAdvice {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	// custom excpetion handling
	// we could also use interceptors to do this
	public ResponseEntity<String> handle(IOException ex){
		// implement rules here
		return null;
	}

}
