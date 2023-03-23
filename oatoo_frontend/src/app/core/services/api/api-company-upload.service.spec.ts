import { TestBed } from '@angular/core/testing';

import { ApiCompanyUploadService } from './api-company-upload.service';

describe('ApiCompanyUploadService', () => {
  let service: ApiCompanyUploadService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiCompanyUploadService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
