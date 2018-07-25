import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { Employe } from '../../metier/employe';
import { EmployeRepositoryService } from '../../services/employe-repository.service';

@Component({
  selector: 'app-employe-edit',
  templateUrl: './employe-edit.component.html',
  styleUrls: ['./employe-edit.component.css']
})
export class EmployeEditComponent implements OnInit, OnChanges {

  @Input() public editId : number;
  public currentEmploye : Employe;

  constructor(private employeRepository : EmployeRepositoryService) { }

  ngOnInit() {
    if (this.editId != 0) {
      // temporaire
      this.currentEmploye = new Employe(0, "doe", "john", "", 0);
    }
    else {
      this.currentEmploye = new Employe(0, "doe", "john", "", 0);
    }
  }

  public cancelEmp() {
    this.currentEmploye = new Employe(0, "doe", "john", "", 0); 
  }

  public saveEmp() {
    if (this.currentEmploye.id == 0){
      this.employeRepository.createEmploye(this.currentEmploye);
    }
    else {
      this.employeRepository.updateEmploye(this.currentEmploye);
    }
    this.currentEmploye = new Employe(0, "doe", "john", "", 0); 
  }
  
  // appelé des qu'un input est modifié
  // en l'occurence, "editId"
  public ngOnChanges(changes : any) {
    this.currentEmploye = this.employeRepository.findById(this.editId);
  }
}
