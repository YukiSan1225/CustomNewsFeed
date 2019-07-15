import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Article } from '../model/article.model';
import { Observable, empty } from 'rxjs';
import { Headers, RequestOptions } from '@angular/http';
import { catchError, timeout } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class FavoriteService {

  constructor(private http : HttpClient) { }

  url = "http://localhost:8080/v1/articles";

  getArticles(){
    return this.http.get<Article[]>(this.url);
  }

  saveArticles(article): Observable<Article>{
    return this.http.post<any>(this.url, JSON.stringify(article), httpOptions);
  }

  removeArticles(article): Observable<Article>{
    return this.http.post<any>(this.url+"/delete", JSON.stringify(article), httpOptions);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      return empty();//of(result as T);
    };
  }
}
