import { Component, OnInit } from '@angular/core';
import { FilmRepositoryService } from '../../services/film-repository.service';

@Component({
  selector: 'app-films-counter',
  templateUrl: './films-counter.component.html',
  styleUrls: ['./films-counter.component.css']
})
export class FilmsCounterComponent implements OnInit {
  public compteur : number;

  constructor(private filmRepository : FilmRepositoryService) { }
  
  ngOnInit() {
    this.compteur = this.filmRepository.getFilms().length;
  }

}
