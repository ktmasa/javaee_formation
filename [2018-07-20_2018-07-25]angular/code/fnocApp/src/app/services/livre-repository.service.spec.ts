import { TestBed, inject } from '@angular/core/testing';

import { LivreRepositoryService } from './livre-repository.service';

describe('LivreRepositoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LivreRepositoryService]
    });
  });

  it('should be created', inject([LivreRepositoryService], (service: LivreRepositoryService) => {
    expect(service).toBeTruthy();
  }));
});
