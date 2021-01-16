import { TestBed } from '@angular/core/testing';

import { MovieSearchApiService } from './movie-search-api.service';

describe('MovieSearchApiService', () => {
  let service: MovieSearchApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovieSearchApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
