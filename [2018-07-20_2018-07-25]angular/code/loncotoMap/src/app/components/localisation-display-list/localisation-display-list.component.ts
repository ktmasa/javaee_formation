import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { LocalisationRepositoryService } from '../../services/localisation-repository.service';
import { Localisation } from '../../metier/localisation';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-localisation-display-list',
  templateUrl: './localisation-display-list.component.html',
  styleUrls: ['./localisation-display-list.component.css']
})
export class LocalisationDisplayListComponent implements OnInit {

  public titre : string;
  public localisationsObservable : Observable<Array<Localisation>>;

  // evenement pouvant etre emit vers le composant parent
  @Output() public editRequired : EventEmitter<number> = new EventEmitter<number>();


  // les arguments du constructeur d'un component seront automatiquement
  // injecté par angular (souvent déclaré dans "providers")
  constructor(private localisationRepository : LocalisationRepositoryService) { }

  ngOnInit() {
    this.titre = "liste des localisations";
    // récupération du tableau des localisation depuis le service localisationRepository
    this.localisationsObservable = this.localisationRepository.getLocalisationsObservable();
    //this.editRequired = new EventEmitter<number>();
  }

  public removeLoc(id : number) {
    this.localisationRepository.removeLocalisation(id);
  }

  public editLoc(id : number) {
    // emission d'un event contenant l'id de la localisation
    // à editer vers le composant parent
    this.editRequired.emit(id);
  }
}
