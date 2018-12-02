import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SwapRequestRecievedComponent } from './swap-request-recieved.component';

describe('SwapRequestRecievedComponent', () => {
  let component: SwapRequestRecievedComponent;
  let fixture: ComponentFixture<SwapRequestRecievedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SwapRequestRecievedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SwapRequestRecievedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
