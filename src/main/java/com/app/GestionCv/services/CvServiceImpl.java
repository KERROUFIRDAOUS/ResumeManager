package com.app.GestionCv.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.GestionCv.model.Cv;
import com.app.GestionCv.model.User;
import com.app.GestionCv.repositories.CvRepository;

@Service
public class CvServiceImpl implements CvService {
	@Autowired
	CvRepository cvRepository;
	
	@Autowired
	UserService userService;

	@Override
	public Cv store(MultipartFile file) throws IOException {
		org.springframework.security.core.Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String email = loggedInUser.getName(); 
	    System.out.println(email);
		User user = userService.findByEmail(email);
		Cv cv = new Cv(user, user.getSousCategories(),file.getBytes());
		cvRepository.save(cv);
		
		return cv;
	}

	@Override
	public Cv getFileById(Long id) {
		Optional<Cv> fileOptional = cvRepository.findById(id);

		if (fileOptional.isPresent()) {
			return fileOptional.get();
		}
		return null;
	}

	@Override
	public Cv getFileByIdUser(Long id) {
		return cvRepository.findByCandidat_id(id);
	}

	@Override
	public Boolean hasCv() {
		org.springframework.security.core.Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String email = loggedInUser.getName(); 
		User user = userService.findByEmail(email);
		System.out.println("psps"+user.getRoles());
		List<Cv> cvs = cvRepository.findAll();
		Boolean flag = false;
		for (Cv cv : cvs) {
			if(user.getId() == cv.getCandidat().getId()) {
				flag = true;
			}
		}
		return flag;
	}


	//@Override
	//public List<Cv> getFileList() {
		//return cvRepository.findAll().stream().map(this::mapToFileResponse).collect(Collectors.toList());
	//}

	//@Override
	//public Cv mapToFileResponse(Cv cv) {
	//	return new Cv(cv.getCandidat() , cv.getSousCategorie(), cv.getDocument());
	//}

}
