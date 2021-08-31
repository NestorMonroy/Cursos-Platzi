import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AngularFireStorage} from "@angular/fire/compat/storage";
import {ProductsService} from "../../../core/services/products/products.service";
import {Router} from "@angular/router";
import { finalize } from 'rxjs/operators';
import {MyValidators} from "../../../utils/validators";
import {Observable} from "rxjs";

@Component({
  selector: 'app-form-product',
  templateUrl: './form-product.component.html',
  styleUrls: ['./form-product.component.scss']
})
export class FormProductComponent implements OnInit {

  form: FormGroup;
  image$: Observable<any>;


  constructor(
    private formBuilder: FormBuilder,
    private productsService: ProductsService,
    private router: Router,
    private storage: AngularFireStorage
  ) {
    this.buildForm();
  }

  ngOnInit(): void {
    console.log('Estas en el componente FormProductComponent')
  }

  saveProduct(event: Event) {
    event.preventDefault() // para que no recarge la pagina **
    console.log(this.form.value)
    if (this.form.valid) {
      const product = this.form.value;
      this.productsService.createProduct(product)
        .subscribe((newProduct) => {
          console.log(newProduct)
          this.router.navigate(['./admin/products'])
        })
    }
  }

  private buildForm() {
    this.form = this.formBuilder.group({
      id: ['', [Validators.required]],
      title: ['', [Validators.required]],
      price: ['', [Validators.required, MyValidators.isPriceValid]],
      image: [''],
      description: ['', [Validators.required]]
    })
  }

  uploadFile(event: Event) {
    const target = event.target as HTMLInputElement;
    const file: File = (target.files as FileList)[0];
    //const file = (event.target as HTMLInputElement).files[0];
    //console.log(file)
    const name = 'image.png';
    const fileRef = this.storage.ref(name);
    const task = this.storage.upload(name, file); //Regresa un observable

    task.snapshotChanges().pipe(
      finalize(() => {
        this.image$ = fileRef.getDownloadURL();
        this.image$.subscribe(url => {
          console.log(url)
          this.form.get('image').setValue(url)
        })
      })
    ).subscribe()

  }

  get priceField() {
    return this.form.get('price')
  }
}
