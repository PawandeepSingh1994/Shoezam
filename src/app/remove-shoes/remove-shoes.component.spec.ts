import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoveShoesComponent } from './remove-shoes.component';

describe('RemoveShoesComponent', () => {
  let component: RemoveShoesComponent;
  let fixture: ComponentFixture<RemoveShoesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RemoveShoesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RemoveShoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
