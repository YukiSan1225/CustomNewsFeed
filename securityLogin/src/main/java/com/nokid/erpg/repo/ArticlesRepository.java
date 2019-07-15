package com.nokid.erpg.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nokid.erpg.dto.ArticleDto;

@Repository
public class ArticlesRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<ArticleDto> getArticles() {
		List<ArticleDto> article = new ArrayList<>();
		
		String sql = "select * from saved_articles";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
		
		for(Map r : result) {
			ArticleDto a = new ArticleDto();
			
			a.setAuthor(r.get("author").toString());
			a.setArticle_content(r.get("article_content").toString());
			a.setDescription(r.get("description").toString());
			a.setSource(r.get("source").toString());
			a.setTitle(r.get("title").toString());
			a.setUrl(r.get("url").toString());
			a.setUrlToImage(r.get("urlToImage").toString());
			
			article.add(a);
		}
		
		return article;
	}
	
	public Integer insertArticles(ArticleDto article){
		StringBuilder sql = new StringBuilder()
				.append("insert into saved_articles (author, article_content, description, ")
				.append(" source, title, url, urlToImage)")
				.append(" values ('"+article.getAuthor().replaceAll("'", "''")+"','"+article.getArticle_content().replaceAll("'", "''")+"'")
				.append(",'"+article.getDescription().replaceAll("'", "''")+"','"+article.getSource().replaceAll("'", "''")+"','"+article.getTitle().replaceAll("'", "''")+"'")
				.append(",'"+article.getUrl().replaceAll("'", "''")+"','"+article.getUrlToImage().replaceAll("'", "''")+"')");
		return jdbcTemplate.update(sql.toString());
	}
	
	public Integer removeArticles(ArticleDto article) {
		StringBuilder sql = new StringBuilder()
				.append("delete from saved_articles where url='"+article.getUrl()+"'");
		return jdbcTemplate.update(sql.toString());
	}
}
