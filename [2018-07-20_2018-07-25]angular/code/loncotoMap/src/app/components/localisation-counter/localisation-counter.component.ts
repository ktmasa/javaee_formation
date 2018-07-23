import { Component, OnInit, OnDestroy } from '@angular/core';
import { LocalisationRepositoryService } from '../../services/localisation-repository.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-localisation-counter',
  templateUrl: './localisation-counter.component.html',
  styleUrls: ['./localisation-counter.component.css']
})
export class LocalisationCounterComponent implements OnInit, OnDestroy {

  public compteur : number;
  private localisationsSouscription : Subscription;

  constructor(private localisationRepository : LocalisationRepositoryService) { }

  ngOnInit() {
    // recuperer la taille du tableau des localisations, autrement dit
    // le nombre de localisations
    //this.compteur = this.localisationRepository.getLocalisations().length;
    this.compteur = 0;
    this.localisationsSouscription =
      this.localisationRepository.getLocalisationsObservable() 
                                  .subscribe(data => {
                                    this.compteur = data.length;
                                  });
  }

  ngOnDestroy(): void {
    this.localisationsSouscription.unsubscribe();
  }
}
