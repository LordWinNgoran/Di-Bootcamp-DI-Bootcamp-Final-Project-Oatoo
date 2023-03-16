import { TestBed } from '@angular/core/testing';

import { ApiTypeCardService } from './api-type-card.service';

describe('ApiTypeCardService', () => {
  let service: ApiTypeCardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiTypeCardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
