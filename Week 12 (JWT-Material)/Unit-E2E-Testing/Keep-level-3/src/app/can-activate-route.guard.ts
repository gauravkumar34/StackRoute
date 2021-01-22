import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { AuthenticationService } from './services/authentication.service';
import { RouterService } from './services/router.service';

@Injectable()
export class CanActivateRouteGuard implements CanActivate {

  constructor(private services :AuthenticationService,private serviceRouter:RouterService) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      const promise = this.services.isUserAuthenticated(this.services.getBearerToken());
      return promise.then((auth) => {
        if(!auth){
          this.serviceRouter.routeToLogin();
        }
        return auth;
      })
  }
}
