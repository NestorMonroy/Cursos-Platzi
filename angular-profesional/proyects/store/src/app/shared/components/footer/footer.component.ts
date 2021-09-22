import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from "@angular/forms";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {

  emailInput: FormControl;

  constructor() {
    this.emailInput = new FormControl('', [
      Validators.required,
      Validators.email
      // Validators.minLength(4),
      // Validators.maxLength(10)
      ]

    );
    // this.emailInput.valueChanges
    //   .subscribe(value => {
    //     console.log(value)
    //   })
  }

  ngOnInit = (): void => {
  };

  registerMail(){
    if(this.emailInput.valid){
      console.log(this.emailInput.value)
    }
  }
}
