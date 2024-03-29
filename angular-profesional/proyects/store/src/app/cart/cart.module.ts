import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";

import {CartComponent} from "./components/cart/cart.component";
import {CartRoutingModule} from "./cart-routing.modules";

@NgModule({
  declarations:[
    CartComponent
  ],
  imports:[
    CommonModule,
    CartRoutingModule
  ]
})
export class CartModule{

}
