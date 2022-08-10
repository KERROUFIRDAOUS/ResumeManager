package com.app.GestionCv.web;

import org.springframework.http.MediaType;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.GestionCv.model.Cv;
import com.app.GestionCv.model.User;
import com.app.GestionCv.services.CvService;
import com.app.GestionCv.services.UserService;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
public class CvController {

	@Autowired
	private CvService cvService;
	@Autowired
	private UserService userService;

	@PostMapping(value = "/uploadFile")
	public void uploadFile(@RequestParam("cv") MultipartFile cv , HttpServletResponse httpResponse) throws IOException {
		System.out.println("good");
		cvService.store(cv);
		httpResponse.sendRedirect("/");
	}

	@GetMapping("cv/{id}")
	public Cv getFile(@PathVariable Long id) {
		return cvService.getFileById(id);
	}

	@RequestMapping(value = "/telechargement")
	public ResponseEntity<byte[]> demo(@RequestParam("id") Long id) {
		Cv cv = cvService.getFileByIdUser(id);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);
		httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION,ContentDisposition.attachment().filename("cv.pdf").build().toString());
		return ResponseEntity.ok().headers(httpHeaders).body(cv.getDocument());
	}
	
	@RequestMapping(value = "/download")
	public ResponseEntity<byte[]> download() {
		org.springframework.security.core.Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String email = loggedInUser.getName(); 
	    System.out.println(email);
		User user = userService.findByEmail(email);
		Cv cv = cvService.getFileByIdUser(user.getId());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);
		httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION,ContentDisposition.attachment().filename("cv.pdf").build().toString());
		return ResponseEntity.ok().headers(httpHeaders).body(cv.getDocument());
	}

	@RequestMapping("/hasCv")
	public Boolean hasCv() {
		System.out.println("pspsss");
		return cvService.hasCv();
	}
	
	


}
