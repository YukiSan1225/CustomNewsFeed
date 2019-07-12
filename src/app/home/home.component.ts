import { Component, OnInit, OnDestroy } from '@angular/core';
import { NewsService } from '../services/news.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit, OnDestroy {

  news: any;
  newsSubscription;
  
  constructor(private newService : NewsService) { }

  ngOnInit() {
    this.getData();
  }

  getData(){
    this.newsSubscription = this.newService.getData('top-headlines?country=us').subscribe(data => {
      this.news = data;
    });
  }

  ngOnDestroy(){
    this.newsSubscription.unsubscribe();
  }
}
