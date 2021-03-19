package fa.whois.exceptionController;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import fa.whois.model.ExceptionModel;
import net.bytebuddy.implementation.ExceptionMethod;



@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handler(Exception e, WebRequest req){
	   ExceptionModel eMsg=new ExceptionModel(new Date(), 
				             req.getDescription(false), 
				             e.getMessage(),
				             e.toString());
		return new ResponseEntity<>(eMsg,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
