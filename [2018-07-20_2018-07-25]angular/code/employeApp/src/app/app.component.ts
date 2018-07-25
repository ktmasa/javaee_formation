import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public currentEditId : number = 0;


  public editIdChanged(id: number) {
    console.log("editId transmitted : " + id);
    this.currentEditId = id;
  }
}
