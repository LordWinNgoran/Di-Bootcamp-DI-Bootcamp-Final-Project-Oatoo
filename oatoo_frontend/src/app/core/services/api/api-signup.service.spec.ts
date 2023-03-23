import { TestBed } from '@angular/core/testing';

import { ApiSignupService } from './api-signup.service';

describe('ApiSignupService', () => {
  let service: ApiSignupService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiSignupService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
