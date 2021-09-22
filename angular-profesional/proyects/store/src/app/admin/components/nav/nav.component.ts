import {Component, ViewChild, ChangeDetectorRef, OnDestroy} from '@angular/core';
import {Router} from "@angular/router";
import {MatSidenav} from '@angular/material/sidenav';

import {MediaMatcher} from '@angular/cdk/layout';


import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import {Observable} from 'rxjs';
import {map, shareReplay} from 'rxjs/operators';
import {AuthService} from "../../../core/services/auth/auth.service";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent {
  @ViewChild('sidenav') sidenav: MatSidenav;
  reason = '';

  close(reason: string) {
    this.reason = reason;
    this.sidenav.close();
  }


  shouldRun = [/(^|\.)plnkr\.co$/, /(^|\.)stackblitz\.io$/].some(h => h.test(window.location.host));

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(
    private breakpointObserver: BreakpointObserver,
    private authService: AuthService,
    private router: Router,
  ) {
  }

  logout() {
    this.authService.logout()
      .then(() =>
        this.router.navigate(['./home']
        ))
  }

}
