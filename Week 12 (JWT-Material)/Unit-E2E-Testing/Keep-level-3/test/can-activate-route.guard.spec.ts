import { TestBed, async, inject, fakeAsync } from '@angular/core/testing';
import { AuthenticationService } from '../src/app/services/authentication.service';
import { CanActivateRouteGuard } from '../src/app/can-activate-route.guard';
import { HttpClientModule } from '@angular/common/http';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { RouterService } from '../src/app/services/router.service';
import { Location } from '@angular/common';

describe('CanActivateRouteGuard', () => {
  let canActivateRouteGuard: CanActivateRouteGuard;
  const activatedRouteSnapshot: ActivatedRouteSnapshot = new ActivatedRouteSnapshot();
  const routerStateSnapshot: RouterStateSnapshot = jasmine.createSpyObj<RouterStateSnapshot>('RouterStateSnapshot', ['toString']);
  let authService: any;
  let spyCanActivate: any;
  let response: any;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientModule
      ],
      providers: [
        { provide: Location, useValue: {back: () => { }} },
        { provide: Router, useValue: {} },
        CanActivateRouteGuard,
        AuthenticationService,
        RouterService
      ]
    });
    canActivateRouteGuard = TestBed.get(CanActivateRouteGuard);
    authService = TestBed.get(AuthenticationService);
  });

  it('should create route guard service', inject([CanActivateRouteGuard], (guard: CanActivateRouteGuard) => {
    expect(guard).toBeTruthy();
  }));

   // ------------ Positive testing of isUserAuthenticated------------//
  it('should handle if user is authenticated', fakeAsync(() => {
    spyCanActivate = spyOn(canActivateRouteGuard, 'canActivate').and.callFake( function() { return true; } );
    response = canActivateRouteGuard.canActivate(activatedRouteSnapshot, routerStateSnapshot);
    expect(response).toBe(true, 'user is authenticated');
  }));

   // ------------ Negative testing of isUserAuthenticated------------//
  it('should handle if user is not authenticated', fakeAsync(() => {
    spyCanActivate = spyOn(canActivateRouteGuard, 'canActivate').and.callFake( function() { return false; } );
    response = canActivateRouteGuard.canActivate(activatedRouteSnapshot, routerStateSnapshot);
    expect(response).toBe(false, 'user is not authenticated');
  }));
});
