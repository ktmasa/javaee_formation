import { Component, OnInit } from '@angular/core';
import { Localisation } from '../../metier/localisation';
import { LocalisationRepositoryService } from '../../services/localisation-repository.service';

@Component({
  selector: 'app-edit-localisation',
  templateUrl: './edit-localisation.component.html',
  styleUrls: ['./edit-localisation.component.css']
})
export class EditLocalisationComponent implements OnInit {

  public currentLoc : Localisation;

  constructor(private localisationRepository : LocalisationRepositoryService) { }

  ngOnInit() {
    this.currentLoc = new Localisation(0, "unknown", "132456", "paris", "france");
  }

  public saveLoc() {
    if (this.currentLoc.id == 0) {
      this.localisationRepository.addLocalisation(this.currentLoc);
    }
    this.currentLoc = new Localisation(0, "unknown", "132456", "paris", "france");
  }
}
