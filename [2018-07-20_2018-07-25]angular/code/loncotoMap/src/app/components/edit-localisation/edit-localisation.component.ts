import { Component, OnInit, Input, OnChanges, SimpleChange } from '@angular/core';
import { Localisation } from '../../metier/localisation';
import { LocalisationRepositoryService } from '../../services/localisation-repository.service';

@Component({
  selector: 'app-edit-localisation',
  templateUrl: './edit-localisation.component.html',
  styleUrls: ['./edit-localisation.component.css']
})
export class EditLocalisationComponent implements OnInit, OnChanges {

  public currentLoc : Localisation;

  // identifiant de l'enregistrement à editer, en provenance
  // du composant parent
  @Input() public editId : number;

  constructor(private localisationRepository : LocalisationRepositoryService) { }

  ngOnInit() {
    console.log("editId = " + this.editId);
    if (this.editId == 0) {
      this.currentLoc = new Localisation(0, "unknown", "132456", "paris", "france");
    }
    else {
      this.currentLoc = this.localisationRepository.findById(this.editId);
    }
  }

  public saveLoc() {
    if (this.currentLoc.id == 0) {
      this.localisationRepository.addLocalisation(this.currentLoc);
    }
    else {
      this.localisationRepository.updateLocalisation(this.currentLoc);
    }
    this.currentLoc = new Localisation(0, "unknown", "132456", "paris", "france");
  }

  public cancelLoc() {
    this.currentLoc = new Localisation(0, "unknown", "132456", "paris", "france");
  }

  // est appelée des que la valeur d'un @input change
  public ngOnChanges(changes : any) {
    console.log("editId changed : " + this.editId);
    if (this.editId == 0) {
      this.currentLoc = new Localisation(0, "unknown", "132456", "paris", "france");
    }
    else {
      this.currentLoc = this.localisationRepository.findById(this.editId);
    }
  }
}
