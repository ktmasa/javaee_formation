import { TestBed, inject } from '@angular/core/testing';

import { FilmRepositoryService } from './film-repository.service';

describe('FilmRepositoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FilmRepositoryService]
    });
  });

  it('should be created', inject([FilmRepositoryService], (service: FilmRepositoryService) => {
    expect(service).toBeTruthy();
  }));
});
