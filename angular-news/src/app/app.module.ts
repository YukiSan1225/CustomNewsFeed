import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { HomeComponent } from './home/home.component';
import { HeadlinesComponent } from './headlines/headlines.component';
import { SourcesComponent } from './sources/sources.component';
import { FavoriteComponent } from './favorites/favorite.component';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { ContactComponent } from './contact/contact.component';
import { UserService } from './services/user.service';
import { FavoriteService } from './services/favorite.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeadlinesComponent,
    SourcesComponent,
    FavoriteComponent,
    ContactComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    HttpModule
  ],
  providers: [UserService, FavoriteService],
  bootstrap: [AppComponent]
})
export class AppModule { }