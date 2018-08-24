import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Page } from '../metier/page';
import { Article } from '../metier/article';

@Injectable({
  providedIn: 'root'
})
export class ArticleRepositoryService {
  private articlesSubject : BehaviorSubject<Page<Article>>;

  constructor(private http : HttpClient) { 
    // on démarre avec une page vide
    this.articlesSubject = new BehaviorSubject<Page<Article>>
                        ( Page.emptyPage<Article>());
  }

  public getArticlesPageAsObservable() : Observable<Page<Article>> {
    return this.articlesSubject.asObservable();
  }
}
