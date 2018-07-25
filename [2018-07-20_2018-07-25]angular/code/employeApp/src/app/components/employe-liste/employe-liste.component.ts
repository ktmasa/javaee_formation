import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Observable } from 'rxjs';
import { Employe } from '../../metier/employe';
import { EmployeRepositoryService } from '../../services/employe-repository.service';

@Component({
  selector: 'app-employe-liste',
  templateUrl: './employe-liste.component.html',
  styleUrls: ['./employe-liste.component.css']
})
export class EmployeListeComponent implements OnInit {

  public employes : Observable<Array<Employe>>;
  @Output() public editRequired : EventEmitter<number>;

  constructor(private employeRepository: EmployeRepositoryService) { 
    this.editRequired = new EventEmitter();
  }

  ngOnInit() {
    this.employes = this.employeRepository.getEmployesAsObservable();
  }

  public editRequested(id: number) {
    console.log("edit requested on " + id);
    this.editRequired.emit(id);
  }

  public removeEmploye(id : number) {
    this.employeRepository.deleteEmploye(id);
  }
}
