import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {

  constructor(
    element: ElementRef
  ) {
    element.nativeElement.style.backgroundColor = 'rgb(255, 255, 119)';
  }

}
