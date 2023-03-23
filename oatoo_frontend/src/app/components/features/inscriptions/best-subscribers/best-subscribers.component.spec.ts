import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BestSubscribersComponent } from './best-subscribers.component';

describe('BestSubscribersComponent', () => {
  let component: BestSubscribersComponent;
  let fixture: ComponentFixture<BestSubscribersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BestSubscribersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BestSubscribersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
