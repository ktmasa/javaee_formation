import { Component, OnInit } from '@angular/core';
import { ArticleRepositoryService } from '../../services/article-repository.service';
import { Subject, Subscription } from 'rxjs';
import { Article } from '../../metier/article';

@Component({
  selector: 'app-article-liste',
  templateUrl: './article-liste.component.html',
  styleUrls: ['./article-liste.component.css']
})
export class ArticleListeComponent implements OnInit {
  // les articles
  public articlesSubject : Subject<Article[]>;
  private articlesSouscription : Subscription;

  constructor(private articleRepository: ArticleRepositoryService) {
    // pour le NgFor
    this.articlesSubject = new Subject<Article[]>();
  }

  ngOnInit() {
    this.articlesSouscription = this.articleRepository
                                    .getArticlesPageAsObservable()
                                    .subscribe( p => {
                                      // je recois les nouvelles pages d'articles
                                      // je transmet au ngFor le tableau des articles
                                      this.articlesSubject.next(p.content);
                                    });
  }

}
