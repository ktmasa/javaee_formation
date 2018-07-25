import { Injectable } from '@angular/core';
import { Employe } from '../metier/employe';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeRepositoryService {

  private employes : Array<Employe>;
  private nextId : number;
  private employesSubject : BehaviorSubject<Array<Employe>>;

  public constructor() { 
    this.employes = [
      new Employe(1, "Rogers", "Steve", "captain@america.com", 20000),
      new Employe(2, "Stark", "Tony", "stark@ironman.com", 200000),
      new Employe(3, "Banner", "Bruce", "bruce@relax.com", 10000)
    ];
    this.nextId = this.employes.length + 1;
    this.employesSubject = new BehaviorSubject(this.employes.slice(0));
  }

  // necessaire aux composants qui veulent ecouter au  modifications
  // de la liste/subject des employes
  public getEmployesAsObservable() : Observable<Array<Employe>> {
    return this.employesSubject.asObservable();
  }

  public createEmploye(emptoinsert : Employe) : void {
    emptoinsert.id = this.nextId;
    this.nextId += 1;
    this.employes.push(emptoinsert);
    this.employesSubject.next(this.employes);
  }

  public findById(id: number) : Employe {
    let index = this.employes.findIndex(emp => emp.id == id);
    if (index >= 0) {
      let employe = new Employe(0, "", "", "", 0);
      employe.copyFrom(this.employes[index]);
      return employe;
    }
    return null;
  }

  public updateEmploye(emptosave : Employe) {
    let index = this.employes.findIndex(emp => emp.id == emptosave.id);
    if (index >= 0) {
      this.employes[index].copyFrom(emptosave);
      this.employesSubject.next(this.employes);
    }
  }

  public deleteEmploye(id : number) {
    let index = this.employes.findIndex(emp => emp.id == id);
    if (index >= 0) {
      this.employes.splice(index, 1);
      this.employesSubject.next(this.employes);
    }
  }


}
