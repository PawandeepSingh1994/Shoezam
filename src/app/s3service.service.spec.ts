import { TestBed } from '@angular/core/testing';

import { S3serviceService } from './s3service.service';

describe('S3serviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: S3serviceService = TestBed.get(S3serviceService);
    expect(service).toBeTruthy();
  });
});
