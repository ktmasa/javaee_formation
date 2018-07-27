import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-intervention-edit',
  templateUrl: './intervention-edit.component.html',
  styleUrls: ['./intervention-edit.component.css']
})
export class InterventionEditComponent implements OnInit {
  public editId : number;

  constructor(private activeRoute : ActivatedRoute) { }

  ngOnInit() {
    this.activeRoute.params.subscribe( values => {
      this.editId = parseInt(values["id"]);
    });
  }

}
