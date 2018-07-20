import { Component } from '@angular/core';
import { Produit } from "./metier/produit";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  p1 : Produit = new Produit(2, "steak de lama", 19.99);


  title = 'wonderful app 2';
  public message : string = 'bonjour, ici angular';

  salutation : string = 'bonjour';
  // tableau de chaine de caractere vide
  courses : string[] = [];
  // pour saisir une nouvelle course
  saisie : string = "";

  addSaisie() {
    this.courses.push(this.saisie);
    this.saisie = "";
    console.log(this.courses);
    console.log(this.p1.description());
  }

  testtypes () {
    let str : string = "bonjour";
    //str = 42;
    let x : number = 15;
    // x = "hoho";
    //str = this.sousfonction(45,12);
  }

  sousfonction(i: number, j:number) : number {
    return i + j;
  }
}
