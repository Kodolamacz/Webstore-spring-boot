import { TestBed, inject } from '@angular/core/testing';

import { ShoppinghistoryService } from './shoppinghistory.service';

describe('ShoppinghistoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ShoppinghistoryService]
    });
  });

  it('should be created', inject([ShoppinghistoryService], (service: ShoppinghistoryService) => {
    expect(service).toBeTruthy();
  }));
});
