import { TestBed, inject } from '@angular/core/testing';

import { EmployeRepositoryService } from './employe-repository.service';

describe('EmployeRepositoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EmployeRepositoryService]
    });
  });

  it('should be created', inject([EmployeRepositoryService], (service: EmployeRepositoryService) => {
    expect(service).toBeTruthy();
  }));
});
