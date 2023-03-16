import { TestBed } from '@angular/core/testing';

import { ApiTypeContractsService } from './api-type-contracts.service';

describe('ApiTypeContractsService', () => {
  let service: ApiTypeContractsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiTypeContractsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
