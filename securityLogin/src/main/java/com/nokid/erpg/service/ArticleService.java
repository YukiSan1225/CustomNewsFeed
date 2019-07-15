package com.nokid.erpg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokid.erpg.dto.ArticleDto;
import com.nokid.erpg.repo.ArticlesRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticlesRepository repo;
		
	public List<ArticleDto> getsArticles(){
		return repo.getArticles();
	}
	public Integer saveArticle(ArticleDto article){
		return repo.insertArticles(article);
	}
	
	public Integer removeArticle(ArticleDto article) {
		return repo.removeArticles(article);
	}
}
