import { Component } from '@angular/core';

import { Product } from '../product.model';
import { ProductsService } from '../products.service';

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
    this.products = this.productsService.getAllProducts();
    console.log(this.products)
  }

  clickProduct(id: number) {
    console.log('Producto: ' + id);
  }

}
