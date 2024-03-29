import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params} from '@angular/router';

import {ProductsService} from '../../../core/services/products/products.service';
import {Product} from '../../../core/models/product.model';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {

  product: Product;
  constructor(
    private route: ActivatedRoute,
    private productsService: ProductsService
  ) { }


  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      const id = params.id;
      this.fetchProduct(id);
    });
  }

  fetchProduct(id:string){
    this.productsService.getProduct(id)
      .subscribe(product => {
        this.product = product;
        //console.log([product])
    })
  }

  createProduct(){
    const newProduct : Product ={
      id: '159',
      title: 'Nuevo desde angular Nestor',
      image: 'assets/images/banner-1.jpg',
      price: 3000,
      description: 'Nuevo producto'
    }
    this.productsService.createProduct(newProduct)
      .subscribe(product => {
        //this.product = product;
        console.log(product)
      })
  }

  updateProduct(){
    const updateProduct : Partial<Product> ={
      id: '159',
      title: 'Actualizado 18 Nestor',
      image: 'assets/images/banner-1.jpg',
      price: 9000,
      description: 'Nuevo producto'
    }
    this.productsService.updateProduct('159', updateProduct)
      .subscribe(product => {
        //this.product = product;
        console.log(product)
      })
  }

  deleteProduct(){
    this.productsService.deleteProduct('159' )
      .subscribe(rta=> {
        console.log(rta)
      })
  }


}
