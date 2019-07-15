package com.nokid.erpg.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nokid.erpg.dto.ArticleDto;
import com.nokid.erpg.service.ArticleService;

@RestController
@CrossOrigin
public class ArticleController {
	
	@Autowired
	private ArticleService service;
	
	private static Logger log = Logger.getLogger(ArticleController.class);
	
	@GetMapping("/v1/articles")
	public ResponseEntity<List<ArticleDto>> getArticles(){
		log.info("/v1/articles [GET] called");
		return new ResponseEntity<List<ArticleDto>>(service.getsArticles(), HttpStatus.OK);
	}
	
	@PostMapping("/v1/articles")
	public ResponseEntity<Integer> saveArticle(@RequestBody ArticleDto article){
		log.info("/v1/articles [POST] called");
		return new ResponseEntity<Integer>(service.saveArticle(article), HttpStatus.OK);
	}
	
	@PostMapping("/v1/articles/delete")
	public ResponseEntity<Integer> removeArticle(@RequestBody ArticleDto article){
		log.info("/v1/articles/delete called");
		return new ResponseEntity<Integer>(service.removeArticle(article), HttpStatus.OK);
	}
}
