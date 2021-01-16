import { TestBed } from '@angular/core/testing';

import { ApiManagerService } from './api-manager.service';

describe('ApiManagerService', () => {
  let service: ApiManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
