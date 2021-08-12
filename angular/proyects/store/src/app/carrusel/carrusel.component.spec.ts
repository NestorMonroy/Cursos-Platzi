import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BankerComponent } from './banker.component';

describe('BanerComponent', () => {
  let component: BankerComponent;
  let fixture: ComponentFixture<BankerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BankerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BankerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
