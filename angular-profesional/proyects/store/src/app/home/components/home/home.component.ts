import {AfterViewInit, Component, OnInit} from '@angular/core';
import Swiper from 'swiper';
import SwiperCore,{ A11y, Navigation, Pagination, Scrollbar } from 'swiper/core';

SwiperCore.use([Navigation, Pagination, Scrollbar, A11y]);
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit, AfterViewInit {

  mySwiper: SwiperCore;

  constructor() {
  }

  ngOnInit = (): void => {
  };

  ngAfterViewInit = () => {
    this.mySwiper = new Swiper('.swiper-container')
        //  navigation: {
        //
        //    // nextEl: ".swiper-button-next",
        //    // prevEl: ".swiper-button-prev"
        // }
  };


}
