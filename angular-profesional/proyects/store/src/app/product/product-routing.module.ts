import {NgModule, NO_ERRORS_SCHEMA, CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";

import {ProductDetailComponent} from "./components/product-detail/product-detail.component";
import  {ProductsComponent} from "./components/products/products.component";

const router: Routes = [
  {
    path:'',
    component:ProductsComponent
  },
  {
    path:':id',
    component:ProductDetailComponent
  }
];

@NgModule({
  imports:[
    RouterModule.forChild(router),
  ],
  exports:[
    RouterModule
  ],
  // schemas: [
  //   CUSTOM_ELEMENTS_SCHEMA,
  //   NO_ERRORS_SCHEMA
  // ]
})

export  class ProductRoutingModule {}
