import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CarruselComponent} from './components/carrusel/carrusel.component';
import {HomeComponent} from './components/home/home.component';

import {HomeRoutingModule} from './home-routing.module';
import {SharedModule} from '../shared/shared.module';

@NgModule({
  declarations:[
    CarruselComponent,
    HomeComponent,
  ],
  imports: [
    CommonModule,
    SharedModule,
    HomeRoutingModule
  ]
})
export class HomeModule {
}
