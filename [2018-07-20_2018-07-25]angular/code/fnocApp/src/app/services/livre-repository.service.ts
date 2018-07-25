import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Livre } from '../metier/livre';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LivreRepositoryService {
  private livresSubject : BehaviorSubject<Array<Livre>>;
  

  // injection du client http
  constructor(private http: HttpClient) { 

    this.livresSubject = new BehaviorSubject([]);
  }

  public getLivresAsObservable() : Observable<Array<Livre>> {
    return this.livresSubject.asObservable();
  }

  public refreshListe() : void {
    // requette vers le serveur
    // il rapellera mon subscribe avec les données déjà convertie
    this.http.get<Array<Livre>>("http://localhost:3000/livres")
             .subscribe(data => {
              this.livresSubject.next(data);
            });
    
  }

  public findById(id : number) : Observable<Livre> {
    return this.http.get<Livre>(`http://localhost:3000/livres/${id}`);
  }

  public deleteLivre(id: number) : void {
    this.http.delete(`http://localhost:3000/livres/${id}`)
             .subscribe( resp => {
               this.refreshListe();
             });
  }
}
