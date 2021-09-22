import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.scss']
})
export class DemoComponent implements OnInit {
  title = 'store-nestor';
  items = ['nestor', 'joel', 'example0']
  objecto = {}; //No es iterable
  power = 10;
  addItem() {
    this.items.push('Nuevo item')
  }

  deleteItem(index: number) {
    this.items.splice(index, 1);
  }

  constructor() { }

  ngOnInit = (): void => {

  };



}
