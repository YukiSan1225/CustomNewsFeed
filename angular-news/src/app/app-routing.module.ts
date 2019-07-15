import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HeadlinesComponent } from './headlines/headlines.component';
import { SourcesComponent } from './sources/sources.component';
import { FavoriteComponent } from './favorites/favorite.component';
import { ContactComponent } from './contact/contact.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'headlines',
    component: HeadlinesComponent
  },
  {
    path: 'sources',
    component: SourcesComponent
  },
  {
    path: 'favorites',
    component: FavoriteComponent
  },
  {
    path: 'contact',
    component: ContactComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
