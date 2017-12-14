package com.dengji85.blog.service.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import com.dengji85.blog.model.File;
import com.dengji85.blog.service.FileGridFsService;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

@Service
public class FileGridFsServiceImpl implements FileGridFsService {
	@Autowired
	private GridFsTemplate fsTemplate;


	public String save(File file) {
		GridFSFile f = this.fsTemplate.store(file.getInputStream(),file.getName(),file.getContentType(),
				file.getMetaData());
		ObjectId id = (ObjectId) f.getId();
		return id.toString();
	}

	public GridFSDBFile getById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));;
		
		GridFSDBFile result = fsTemplate.findOne(query );
		return result;
		
	}
}
