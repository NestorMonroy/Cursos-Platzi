import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CarruselComponent} from './components/carrusel/carrusel.component';
import {HomeComponent} from './components/home/home.component';

import {HomeRoutingModule} from './home-routing.module'

@NgModule({
  declarations:[
    CarruselComponent,
    HomeComponent,
  ],
  imports: [
    CommonModule,
    HomeRoutingModule
  ]
})
export class HomeModule {
}
