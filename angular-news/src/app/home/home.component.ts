import { Component, OnInit, OnDestroy } from '@angular/core';
import { NewsService } from '../services/news.service';
import { Article } from '../model/article.model';
import { FavoriteService } from '../services/favorite.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit, OnDestroy {

  news: any;
  newsSubscription;
  a : Article;
  response : any;

  constructor(private newService : NewsService, 
              private favService : FavoriteService,
              private snackBar : MatSnackBar) { }

  ngOnInit() {
    this.getData();
  }

  getData(){
    this.newsSubscription = this.newService.getData('top-headlines?country=us').subscribe(data => {
      this.news = data;
    });
  }

  onFavorite(article){
    this.a = new Article;

    this.a.author = article["author"];
    this.a.article_content = article["content"];
    this.a.description = article["description"];
    this.a.source = JSON.stringify(article["source"]);
    this.a.title = article["title"];
    this.a.url = article["url"];
    this.a.urlToImage = article["urlToImage"];

    this.favService.saveArticles(this.a).subscribe(
      response => {
        this.response = response;
        if(this.response == 1){
          this.snackBar.open('Favorite Added', 'OK',{
            duration: 3000
          });
        } else {
          this.snackBar.open('Favorite Add Failed', 'OK', {
            duration : 3000
          });
        }
      }
    );
  }

  onNavigate(url){
    window.open(url);
  }

  ngOnDestroy(){
    this.newsSubscription.unsubscribe();
  }
}
