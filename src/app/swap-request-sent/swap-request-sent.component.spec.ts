import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SwapRequestSentComponent } from './swap-request-sent.component';

describe('SwapRequestSentComponent', () => {
  let component: SwapRequestSentComponent;
  let fixture: ComponentFixture<SwapRequestSentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SwapRequestSentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SwapRequestSentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
