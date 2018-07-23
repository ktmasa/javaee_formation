import { TestBed, inject } from '@angular/core/testing';

import { LocalisationRepositoryService } from './localisation-repository.service';

describe('LocalisationRepositoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LocalisationRepositoryService]
    });
  });

  it('should be created', inject([LocalisationRepositoryService], (service: LocalisationRepositoryService) => {
    expect(service).toBeTruthy();
  }));
});
