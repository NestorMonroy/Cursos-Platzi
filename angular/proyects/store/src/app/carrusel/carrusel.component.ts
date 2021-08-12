import { Component, OnInit } from '@angular/core';
import SwiperCore, { A11y, Navigation, Pagination, Scrollbar } from 'swiper/core';

SwiperCore.use([Navigation, Pagination, Scrollbar, A11y])

@Component({
  selector: 'app-carrusel',
  templateUrl: './carrusel.component.html',
  styleUrls: ['./carrusel.component.scss']
})
export class CarruselComponent implements OnInit {

  images: string[] = [
    'assets/images/banner-1.jpg',
    'assets/images/banner-2.jpg',
    'assets/images/banner-3.jpg',
  ];

  onSwiper(swiper: any){
    console.log(swiper);
  }

  onSlideChange(){
    console.log('slide change');
  }

  ngOnInit = (): void => {
  };
}

