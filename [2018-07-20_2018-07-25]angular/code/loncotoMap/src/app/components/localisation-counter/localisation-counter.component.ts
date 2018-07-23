import { Component, OnInit } from '@angular/core';
import { LocalisationRepositoryService } from '../../services/localisation-repository.service';

@Component({
  selector: 'app-localisation-counter',
  templateUrl: './localisation-counter.component.html',
  styleUrls: ['./localisation-counter.component.css']
})
export class LocalisationCounterComponent implements OnInit {
  public compteur : number;

  constructor(private localisationRepository : LocalisationRepositoryService) { }

  ngOnInit() {
    // recuperer la taille du tableau des localisations, autrement dit
    // le nombre de localisations
    this.compteur = this.localisationRepository.getLocalisations().length;
  }

}
