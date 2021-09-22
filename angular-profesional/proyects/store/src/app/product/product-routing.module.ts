import {NgModule, NO_ERRORS_SCHEMA, CUSTOM_ELEMENTS_SCHEMA} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";

import {ProductDetailComponent} from "./components/product-detail/product-detail.component";
import  {ProductsContainer} from "./containers/products/products.container";

const router: Routes = [
  {
    path:'',
    component:ProductsContainer
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
