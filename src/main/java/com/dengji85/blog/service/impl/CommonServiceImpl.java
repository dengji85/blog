package com.dengji85.blog.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dengji85.blog.mapper.VisitMapper;
import com.dengji85.blog.model.Visit;
import com.dengji85.blog.model.VisitExample;
import com.dengji85.blog.model.VisitExample.Criteria;
import com.dengji85.blog.service.CommonService;
@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	private VisitMapper visitMapper;
	@Override
	public void addVisit(Visit visit) {
		visit.setAddTime(new Date());
		this.visitMapper.insertSelective(visit);

	}
	@Override
	public boolean exist(Visit visit) {
		boolean result = false;
		VisitExample example = new VisitExample();
		Criteria criteria = example.createCriteria();
		criteria.andIpEqualTo(visit.getIp());
		criteria.andUrlEqualTo(visit.getUrl());
		int count = this.visitMapper.countByExample(example );
		if(count>0){
			result = true;	
		}
		return result;
	}

}
