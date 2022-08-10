package com.app.GestionCv.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.GestionCv.model.Cv;
import com.app.GestionCv.model.User;

public interface CvService {
	public Cv store(MultipartFile file) throws IOException;
	public Cv getFileById(Long id);
	public Cv getFileByIdUser(Long id);
	public Boolean hasCv();
	//spublic List<Cv> getFileList();
	//public Cv mapToFileResponse(Cv cv);
}
