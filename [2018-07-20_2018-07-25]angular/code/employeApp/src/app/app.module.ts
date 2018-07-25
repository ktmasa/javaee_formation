import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";

import { AppComponent } from './app.component';
import { EmployeEditComponent } from './components/employe-edit/employe-edit.component';
import { EmployeListeComponent } from './components/employe-liste/employe-liste.component';
import { EmployeRepositoryService } from './services/employe-repository.service';

@NgModule({
  declarations: [
    AppComponent,
    EmployeEditComponent,
    EmployeListeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [EmployeRepositoryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
