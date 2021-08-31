import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {Product} from "../../models/product.model";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private products: Product[] = []
  private cart = new BehaviorSubject<Product[]>([]);

  cart$ = this.cart.asObservable();

  constructor() { }

  addCart(product:Product){
    this.products = [...this.products, product];
    this.cart.next(this.products);
  }

  deleteProduct(id:string){
    // No se debe modificar el observable directamente
    // se deve actualizar el array simple de productos y luego ese array asignarselo al array observable

    // Opcion menos eficiente
    /* this.products = this.products.filter((product:any) => {
      return product.id !== id;
    }) */

    // Opcion mas eficiente
    const eliminar = this.products.findIndex(product => product.id === id);
    this.products.splice(eliminar, 1)

    this.cart.next(this.products);
  }

  clearCart() {
    //this.cart$ = of(<any>[]);
    this.cart.next([]);
  }
}
