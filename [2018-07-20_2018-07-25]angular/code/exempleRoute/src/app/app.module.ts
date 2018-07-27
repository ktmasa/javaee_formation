import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from "@angular/router";
import { AppComponent } from './app.component';
import { InterventionListeComponent } from './components/intervention-liste/intervention-liste.component';
import { ArticleListeComponent } from './components/article-liste/article-liste.component';
import { InterventionEditComponent } from './components/intervention-edit/intervention-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    InterventionListeComponent,
    ArticleListeComponent,
    InterventionEditComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      { path: 'home', component: InterventionListeComponent},
      { path: 'articles', component: ArticleListeComponent},
      { path: 'edit/:id', component: InterventionEditComponent},
      { path: '', redirectTo: '/home', pathMatch: 'full'}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
