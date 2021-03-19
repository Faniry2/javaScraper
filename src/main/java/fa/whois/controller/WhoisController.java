package fa.whois.controller;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.org.apache.bcel.internal.generic.NEW;

import fa.whois.model.Data;
import fa.whois.service.WhoisService;

@RestController
public class WhoisController {

	@Autowired
	WhoisService srv;
	
	
	@RequestMapping("/q")
	public ResponseEntity<Object> getWhoisData(@RequestParam(value="ipOrDomaineName",required=true)String str) throws Exception{
		Data data=null;
		try{
			data=srv.scrapWhois(str);
			
		}catch(Exception e){
		  
			 StringWriter sw=new StringWriter();
			 e.printStackTrace(new PrintWriter(sw));
			 throw new Exception(e.toString()); 
		  
			
		}
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
}
