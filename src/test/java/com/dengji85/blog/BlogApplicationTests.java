package com.dengji85.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dengji85.blog.mapper.ArticleMapper;
import com.dengji85.blog.model.Article;
import com.dengji85.blog.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BlogApplicationTests {
	@Autowired
	private ArticleService articleService;
	@Autowired
	ArticleMapper articleMapper;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testArticleService() {

		Article article = new Article();
		article.setDescription("test");
		this.articleMapper.insertSelective(article);
	}

}
