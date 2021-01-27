import { TestBed } from '@angular/core/testing';

import { PizzaApiService } from './pizza-api.service';

describe('PizzaApiService', () => {
  let service: PizzaApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PizzaApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
