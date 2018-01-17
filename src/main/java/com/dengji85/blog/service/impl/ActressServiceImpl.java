package com.dengji85.blog.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dengji85.blog.common.AjaxPagerResult;
import com.dengji85.blog.mapper.ActressMapper;
import com.dengji85.blog.model.Actress;
import com.dengji85.blog.model.ActressExample;
import com.dengji85.blog.param.ActressParam;
import com.dengji85.blog.service.ActressService;

@Service
public class ActressServiceImpl implements ActressService {
	@Autowired
	private ActressMapper actressMapper;

	@Override
	public void addActress(Actress actress) {
		// TODO Auto-generated method stub

	}

	@Override
	public Actress searchByParam(ActressParam param) {
		
		return null;
	}

	@Override
	public AjaxPagerResult<Actress> page(ActressParam param) {
		AjaxPagerResult<Actress> page = new AjaxPagerResult<>();
		ActressExample example = new ActressExample();
		//example.setOrderByClause("");
		RowBounds rowBounds = new RowBounds(param.getOffSet(), param.getLimit());
		List<Actress> list = this.actressMapper.selectByExampleWithRowbounds(example, rowBounds);
		page.setCount(this.actressMapper.countByExample(example));
		page.setData(list);
		return page;
	}

	@Override
	public void deleteActressById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateActress(Actress actress) {
		this.actressMapper.updateByPrimaryKeySelective(actress);

	}

	@Override
	public List<Actress> getHot(int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Actress searchById(ActressParam param) {
		
		return this.actressMapper.selectByPrimaryKey(param.getId());
	}

}
