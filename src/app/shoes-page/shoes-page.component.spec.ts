import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShoesPageComponent } from './shoes-page.component';

describe('ShoesPageComponent', () => {
  let component: ShoesPageComponent;
  let fixture: ComponentFixture<ShoesPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShoesPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShoesPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
