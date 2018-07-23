import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";

import { AppComponent } from './app.component';
import { FilmRepositoryService } from './services/film-repository.service';
import { FilmsDisplayComponent } from './components/films-display/films-display.component';
import { FilmsEditComponent } from './components/films-edit/films-edit.component';
import { FilmsCounterComponent } from './components/films-counter/films-counter.component';

@NgModule({
  declarations: [
    AppComponent,
    FilmsDisplayComponent,
    FilmsEditComponent,
    FilmsCounterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [
    FilmRepositoryService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
