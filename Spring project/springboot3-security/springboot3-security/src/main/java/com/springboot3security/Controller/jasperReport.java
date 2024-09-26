package com.springboot3security.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot3security.Service.ReportService;

import jakarta.annotation.Resource;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/auth")
public class jasperReport {
	
	@Autowired
	
	private ReportService service;
	

	   public jasperReport(ReportService service) {
	       this.service = service;
	   }
		
	
//	 @GetMapping("/report")
//	    public byte[] generateReport() throws FileNotFoundException, JRException {
//		 String format="pdf";
//	        return service.exportReport(format);
//	    }
//
//
//	 
	   
	   
	   @RequestMapping("/home")
	   public void Home() {
		   System.out.println("home page");
	   }
	 
	   
	   

	  
	   
//	   @GetMapping("/report")
//	    public ResponseEntity<ByteArrayResource> generateReport() {
//	        try {
//	            byte[] reportBytes = service.generateReport();
//
//	            ByteArrayResource resource = new ByteArrayResource(reportBytes);
//
//	            HttpHeaders headers = new HttpHeaders();
//	            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=loginreport.pdf");
//
//	            return ResponseEntity.ok()
//	                    .headers(headers)
//	                    .contentType(MediaType.APPLICATION_PDF)
//	                    .contentLength(reportBytes.length)
//	                    .body(resource);
//	        } catch (IOException | JRException e) {
//	            e.printStackTrace(); // Handle exception appropriately
//	            return ResponseEntity.badRequest().build();
//	        }
//	    }
	  
	   @GetMapping("/generateReport")
	    public ResponseEntity<ByteArrayResource> generateReport() {
	        try {
	            byte[] reportBytes = service.generateReport();

	            // Create ByteArrayResource from reportBytes
	            ByteArrayResource resource = new ByteArrayResource(reportBytes);

	            // Set up headers
	            HttpHeaders headers = new HttpHeaders();
	            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf");

	            // Return ResponseEntity with ByteArrayResource and headers
	            return ResponseEntity.ok()
	                    .headers(headers)
	                    .contentType(MediaType.APPLICATION_PDF)
	                    .body(resource);
	        } catch (IOException | JRException e) {
	            e.printStackTrace(); // Handle exception appropriately
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	    }
	 
}
