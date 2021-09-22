import { Component } from '@angular/core';

import { Product } from '../../../core/models/product.model';
import { ProductsService } from '../../../core/services/products/products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent {

  products: Product[];
  constructor(private productsService: ProductsService) { }

  // eslint-disable-next-line @angular-eslint/use-lifecycle-interface
  ngOnInit() {
    this.fetchProducts();
  }
// eslint-disable-next-line @angular-eslint/use-lifecycle-interface


  clickProduct(id: number) {
    console.log('Producto: ' + id);
  }

  fetchProducts() {
    this.productsService.getAllProducts()
      .subscribe(products => {
        //console.log([products])
        this.products = products;
      });
  }
}
