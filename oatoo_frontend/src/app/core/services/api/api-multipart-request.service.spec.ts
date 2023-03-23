import { TestBed } from '@angular/core/testing';

import { ApiMultipartRequestService } from './api-multipart-request.service';

describe('ApiMultipartRequestService', () => {
  let service: ApiMultipartRequestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiMultipartRequestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
