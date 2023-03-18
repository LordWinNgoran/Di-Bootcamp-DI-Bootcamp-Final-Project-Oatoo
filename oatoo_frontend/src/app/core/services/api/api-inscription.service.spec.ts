import { TestBed } from '@angular/core/testing';

import { ApiInscriptionService } from './api-inscription.service';

describe('ApiInscriptionService', () => {
  let service: ApiInscriptionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiInscriptionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
