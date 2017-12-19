package com.dengji85.blog.config;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dengji85.blog.model.Article;
import com.dengji85.blog.model.Visit;
import com.dengji85.blog.param.ArticleParam;
import com.dengji85.blog.resultmap.ArticleResultMap;
import com.dengji85.blog.service.ArticleService;
import com.dengji85.blog.service.CommonService;

@Aspect
@Component
public class VisitAspect {
	@Autowired
	private CommonService commonService;
	@Autowired
	private ArticleService articleService;
	private Logger log = LoggerFactory.getLogger(getClass());

	@Pointcut("execution(* com.dengji85.blog.controller..*.*(..))")
	public void visitLog() {
	};

	@After("visitLog()")
	public void doAfter(JoinPoint joinPoint) {
		log.debug("-------------------------");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		if (request.getRequestURI().matches("^(/article/)\\d+$")) {
			ArticleParam param = new ArticleParam();
			String uri = request.getRequestURI();
			String id = uri.substring(uri.lastIndexOf("/")+1);
			param.setId(Long.parseLong(id));
			ArticleResultMap article = this.articleService.searchByParam(param );
			if (null != article ) {
				Visit v = new Visit();
				v.setIp(request.getRemoteAddr());
				v.setUrl(request.getRequestURI());
				if (!this.commonService.exist(v)) {

					Article a = new Article();
					a.setId(article.getId());
					a.setViewNum(article.getViewNum() + 1);
					this.articleService.updateArtice(a);

				}
			}
		}

		Visit v = new Visit();
		v.setUrl(request.getRequestURI().toString());
		v.setIp(request.getRemoteAddr());
		v.setHttpMethod(request.getMethod());
		v.setClassMethod(joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		log.debug(JSONObject.wrap(v).toString());
		commonService.addVisit(v);
	}
	
	public static void main(String[] args) {
		String s ="/article/40";
		boolean b= s.matches("^(/article/)\\d+$");
		System.out.println(b);
				
	}
}
