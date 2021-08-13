import { AfterViewInit, Component, OnInit } from '@angular/core';
import Swiper from 'swiper';
//import SwiperCore, { A11y, Navigation, Pagination, Scrollbar } from 'swiper/core';

//SwiperCore.use([Navigation, Pagination, Scrollbar, A11y])
import { SwiperComponent } from 'swiper/angular';
import SwiperCore, {
  Navigation,
  Pagination,
  Mousewheel,
  Keyboard,
} from 'swiper/core';

SwiperCore.use([Navigation, Pagination, Mousewheel, Keyboard]);
@Component({
  selector: 'app-carrusel',
  templateUrl: './carrusel.component.html',
  styleUrls: ['./carrusel.component.scss']
})
export class CarruselComponent implements OnInit, AfterViewInit {

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
  }

  ngAfterViewInit(){
    const swiper = new Swiper('.swiper-container',{
      // slidesPerView: 5.3,
      // freeMode: true,
      // spaceBetween: 15,
      cssMode: true,
      // mousewheel: true,
      // keyboard: true,
      // slidesPerView: 1,
      // spaceBetween: 30,
      // loop: true,
      pagination: {
        el: '.swiper-pagination',
        // clickable: true,
      },
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    });
    console.log(swiper)
  }
}

