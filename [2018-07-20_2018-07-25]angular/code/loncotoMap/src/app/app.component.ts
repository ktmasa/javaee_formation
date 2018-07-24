import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  public currentEditId : number;

  public constructor() {
    this.currentEditId = 0;
  }

  public editRequested(id: number) {
    console.log("recus demande edition localisation no " + id);
    this.currentEditId = id;
  }
}
