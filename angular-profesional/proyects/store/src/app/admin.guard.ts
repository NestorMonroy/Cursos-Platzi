import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import {Observable} from 'rxjs';
import {map, tap} from 'rxjs/operators'
import {AuthService} from "./core/services/auth/auth.service";

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {
  constructor(
    private authService: AuthService,
    private router: Router
  ) {
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.authService.hasUser().pipe(
      // map(user => user === null ? false : true),
      // tap(hasUser =>{
      //   if(!hasUser){
      //     this.router.navigate(['auth/login'])
      //   }
      // })
      map(user => user ? true : this.router.parseUrl('/auth/login') )
    );
  }

}
