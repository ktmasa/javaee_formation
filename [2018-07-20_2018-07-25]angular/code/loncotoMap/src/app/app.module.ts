import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LocalisationRepositoryService } from './services/localisation-repository.service';
import { LocalisationDisplayListComponent } from './components/localisation-display-list/localisation-display-list.component';
import { LocalisationCounterComponent } from './components/localisation-counter/localisation-counter.component';

@NgModule({
  declarations: [
    AppComponent,
    LocalisationDisplayListComponent,
    LocalisationCounterComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [LocalisationRepositoryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
