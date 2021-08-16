import { NgModule } from '@angular/core';
import { RouterModule, Routes, PreloadAllModules } from '@angular/router';
import {HomeComponent} from './home/components/home/home.component';
import {ProductsComponent} from './product/components/products/products.component';
import {ContactComponent} from './contact/module/contact/contact.component';
import {DemoComponent} from './demo/demo.component';
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import {ProductDetailComponent} from "./product/components/product-detail/product-detail.component";
import {LayoutComponent} from "./layout/layout.component";

import {AdminGuard} from './admin.guard';

const routes: Routes = [
  {
    path:'',
    component: LayoutComponent,
    children:[
      {
        path:'',
        redirectTo:'home',
        pathMatch: 'full',
      },
      {
        path:'home',
        loadChildren: () => import('./home/home.module').then(h => h.HomeModule)
      },
      {
        path: 'products',
        loadChildren: () => import('./product/product.module').then(p => p.ProductModule)
      },
      {
        path:'contact',
        //canActivate: [AdminGuard],
        loadChildren: () => import('./contact/contact.module').then(c => c.ContactModule)

      },
      {
        path:'demo',
        component: DemoComponent
      },
      {
        path:'admin',
        loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule)
      },
      {
        path:'**',
        component: PageNotFoundComponent
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {preloadingStrategy: PreloadAllModules})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
