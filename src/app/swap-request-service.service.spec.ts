import { TestBed } from '@angular/core/testing';

import { SwapRequestServiceService } from './swap-request-service.service';

describe('SwapRequestServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SwapRequestServiceService = TestBed.get(SwapRequestServiceService);
    expect(service).toBeTruthy();
  });
});
