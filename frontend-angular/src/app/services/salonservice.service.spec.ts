import { TestBed } from '@angular/core/testing';

import { SalonserviceService } from './salonservice.service';

describe('SalonserviceService', () => {
  let service: SalonserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SalonserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
