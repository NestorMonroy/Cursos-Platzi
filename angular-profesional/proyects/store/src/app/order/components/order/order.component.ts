import {Component, OnInit} from '@angular/core';
import {Product} from "../../../core/models/product.model";
import {CartService} from "../../../core/services/cart/cart.service";
import {Observable} from "rxjs";
import {map} from 'rxjs/operators';

import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';

import {StepperOrientation} from '@angular/material/stepper';
import {BreakpointObserver} from '@angular/cdk/layout';


interface OrderProduct extends Product {
  quantity: number;
  total: number;
}

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {
  products: OrderProduct[] = [];
  compraExitosa = false;
  formError = false;
  formErrorMesagge = '';
  //subtotal = products$.forEach(product.price => suma = suma+ product);

  // formGroup1: FormGroup;
  formGroup1 = this.formBuilder.group({
    nombre: ['', Validators.required],
    apellido: ['', Validators.required],
    documento: ['', Validators.required],
    direccion: ['', Validators.required],
    ciudad: ['', Validators.required],
    estado: ['', Validators.required],
    shipping: ['free', Validators.required]
  });


  formGroup2 = new FormGroup({
    formaPago: new FormControl('', Validators.required)
  });

  stepperOrientation: Observable<StepperOrientation>;

  constructor(
    private cartService: CartService,
    private formBuilder: FormBuilder,
    private toastr: ToastrService,
    breakpointObserver: BreakpointObserver,
  ) {
    this.compraExitosa = false;

    this.stepperOrientation = breakpointObserver.observe('(min-width: 800px)')
      .pipe(map(({matches}) => matches ? 'horizontal' : 'vertical'));

    this.cartService.cart$
      .pipe(
        map((products) => {
          const groupedProducts: OrderProduct[] = [];

          products.forEach((product) => {
            const index = groupedProducts.findIndex((gp) => gp.id === product.id);

            if (index >= 0) {
              groupedProducts[index].quantity += 1;
              groupedProducts[index].total += product.price;
            } else {
              groupedProducts.push({
                ...product,
                quantity: 1,
                total: product.price
              });
            }
          });

          return groupedProducts;
        })
      )
      .subscribe((products) => {
        this.products = products;
      });

  }


  ngOnInit(): void {
    this.compraExitosa = false;
  }

  repeticiones(producto: string) {

  }

  pagoCompra() {

    if (this.formGroup2.valid) {
      // registrar compra en la base de datos
      this.cartService.clearCart();
      this.compraExitosa = true;
      this.formError = false;
      this.formErrorMesagge = '';
      this.formGroup1.reset();
    } else {
      this.compraExitosa = false;
    }

    if (this.formGroup2.hasError('required')) {
    }

    if (this.formGroup2.controls.formaPago.untouched) {
      this.formError = true;
      this.formErrorMesagge = 'Forma de pago es requerida.';
      this.compraExitosa = false;
    }
  }

  get form2() {
    if (this.formGroup2.get('formaPago')) {
    }

    return this.formGroup2.controls;
  }

  deleteProduct(id: string) {
    this.cartService.deleteProduct(id);
    this.toastr.error('¡Producto eliminado con éxito!', 'Producto eliminado.',
      {
        positionClass: 'toast-bottom-right',
        closeButton: true,
        newestOnTop: true,
      });

    console.log("Producto eliminado del carrito");
  }
}
