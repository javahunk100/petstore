package com.petstore.web.rest.api.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 
 * @author Nagendra
 *
 */
@ControllerAdvice
public class PetStoreAppExceptionAdvice {
	
	@ExceptionHandler(PetStoreException.class)
	public ResponseEntity<PetStoreApErrorMessage> exceptionHandler(HttpServletRequest req,PetStoreException ex) {
		PetStoreApErrorMessage petStoreApErrorMessage = new PetStoreApErrorMessage();
		petStoreApErrorMessage.setStatusCode(HttpStatus.PRECONDITION_FAILED.value()+"");
		petStoreApErrorMessage.setException(ex.getMessage());
		petStoreApErrorMessage.setUrl(req.getRequestURL().toString());
		petStoreApErrorMessage.setMessage("Error occurs during server side processing");
		return new ResponseEntity<PetStoreApErrorMessage>(petStoreApErrorMessage, HttpStatus.OK);
	}
	
	/**
	 *  <init-param>
        <param-name>throwExceptionIfNoHandlerFound</param-name>
        <param-value>true</param-value>
    	</init-param>
	 * @param req
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<PetStoreApErrorMessage> handleError404(HttpServletRequest req, Exception ex)   {
		PetStoreApErrorMessage petStoreApErrorMessage = new PetStoreApErrorMessage();
		petStoreApErrorMessage.setStatusCode(HttpStatus.NOT_FOUND.value()+"");
		petStoreApErrorMessage.setException(ex.getMessage());
		petStoreApErrorMessage.setUrl(req.getRequestURL().toString());
		petStoreApErrorMessage.setMessage("Error occurs during mapping the request at server side processing");
		return new ResponseEntity<PetStoreApErrorMessage>(petStoreApErrorMessage, HttpStatus.OK);
    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<PetStoreApErrorMessage> exceptionHandler(HttpServletRequest req,Exception ex) {
		PetStoreApErrorMessage petStoreApErrorMessage = new PetStoreApErrorMessage();
		petStoreApErrorMessage.setStatusCode(HttpStatus.PRECONDITION_FAILED.value()+"");
		petStoreApErrorMessage.setException(ex.getMessage());
		petStoreApErrorMessage.setUrl(req.getRequestURL().toString());
		petStoreApErrorMessage.setMessage("General error occurs during server side processing");
		return new ResponseEntity<PetStoreApErrorMessage>(petStoreApErrorMessage, HttpStatus.OK);
	}
	
}
