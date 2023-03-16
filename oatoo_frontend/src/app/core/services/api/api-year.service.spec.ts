import { TestBed } from '@angular/core/testing';

import { ApiYearService } from './api-year.service';

describe('ApiYearService', () => {
  let service: ApiYearService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiYearService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
