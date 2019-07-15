import { Component, OnInit } from '@angular/core';
import { Article } from '../model/article.model';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { FavoriteService } from '../services/favorite.service';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.scss']
})
export class FavoriteComponent implements OnInit {

  articles: Article[];
  response : any;

  constructor(private route : Router, 
              private service : FavoriteService,
              private snackBar : MatSnackBar) { }

  ngOnInit() {
    this.service.getArticles()
    .subscribe( data => {
      this.articles = data;
    });
  }

  deleteFavorite(article){
    this.service.removeArticles(article).subscribe(
      response => {
        this.response = response;
        if(this.response > 0){
          this.snackBar.open('Favorite Removed', 'OK',{
            duration: 3000
          });
        } else {
          this.snackBar.open('Favorite Not Removed', 'OK', {
            duration: 3000
          });
        }
      }
    );
  }
}