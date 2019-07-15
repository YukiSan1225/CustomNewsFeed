import { Component, OnInit } from '@angular/core';
import { NewsService } from '../services/news.service';
import { catchError } from 'rxjs/operators';

@Component({
  selector: 'app-headlines',
  templateUrl: './headlines.component.html',
  styleUrls: ['./headlines.component.scss']
})
export class HeadlinesComponent implements OnInit {

  news;
  categories = [
    'World',
    'India',
    'Business',
    'Technology',
    'Entertainment',
    'Sports',
    'Science',
    'Cyber Security'
  ];

  constructor(private newsService : NewsService) { }

  ngOnInit() {
    this.getCategoryData(this.categories[0]);
  }

  onGetCategoryData(category){
    console.log(category);
    this.getCategoryData(category);
  }

  getCategoryData(category){
    if(category == 'Cyber Security'){
      this.newsService.getData(`top-headlines?sources=hacker-news`).subscribe(
        data =>{
          this.news = data;
        }
      )
    }
    else{
      this.newsService.getData(`everything?q=${category.toLowerCase()}`).subscribe(
        data => {
          this.news = data;
        }
      );
    }
  }

  
  onNavigate(url){
    window.open(url);
  }

}
