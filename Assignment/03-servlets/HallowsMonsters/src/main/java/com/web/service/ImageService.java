package com.web.service;

import java.io.File;

import com.web.repo.DaoContract;
import com.web.repo.ImageDao;

public class ImageService {
	
	private DaoContract <File, String> idao;
	
	public ImageService() {
		this(new ImageDao());
	}

	public ImageService(DaoContract<File,String> imageTestDao) {
		super();
		this.idao = imageTestDao;
	}
	
	public int insert(File file) {
		return idao.create(file);
	}
	
	public File findByName(String name) {
		return idao.findByName(name);
	}

}
