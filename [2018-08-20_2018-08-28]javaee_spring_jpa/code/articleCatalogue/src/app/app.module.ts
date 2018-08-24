import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { RouterModule } from "@angular/router";
import { HttpClientModule } from "@angular/common/http";
import { PaginationModule } from "ngx-bootstrap/pagination";
import { AppComponent } from './app.component';
import { ArticleListeComponent } from './components/article-liste/article-liste.component';

@NgModule({
  declarations: [
    AppComponent,
    ArticleListeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    PaginationModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
