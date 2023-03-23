import { TestBed } from '@angular/core/testing';

import { ApiUnemployeeService } from './api-unemployee.service';

describe('ApiUnemployeeService', () => {
  let service: ApiUnemployeeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiUnemployeeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
