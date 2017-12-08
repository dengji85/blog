package com.dengji85.blog.service;

import com.dengji85.blog.model.File;
import com.mongodb.gridfs.GridFSDBFile;

public interface FileGridFsService {
	
	public String save(File file);
	public GridFSDBFile getById(String id);
}
