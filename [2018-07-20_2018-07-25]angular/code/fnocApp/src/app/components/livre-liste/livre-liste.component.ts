import { Component, OnInit } from '@angular/core';
import { LivreRepositoryService } from '../../services/livre-repository.service';
import { Observable } from 'rxjs';
import { Livre } from '../../metier/livre';

@Component({
  selector: 'app-livre-liste',
  templateUrl: './livre-liste.component.html',
  styleUrls: ['./livre-liste.component.css']
})
export class LivreListeComponent implements OnInit {

  public livres : Observable<Array<Livre>>;
  public livreEditId : number;

  constructor(private livreRepository: LivreRepositoryService) { }

  ngOnInit() {
    this.livreEditId = 0;
    this.livres = this.livreRepository.getLivresAsObservable();
    // rafraichir la liste des livres depuis le serveur
    this.livreRepository.refreshListe();
  }

  public clickdeleteLivre(id: number) {
    this.livreRepository.deleteLivre(id);
  }

  public clickeditLivre(id : number) {
    // identifiant du livre a mettre dans le formulaire d'edition
    this.livreEditId = id;
  }
}
