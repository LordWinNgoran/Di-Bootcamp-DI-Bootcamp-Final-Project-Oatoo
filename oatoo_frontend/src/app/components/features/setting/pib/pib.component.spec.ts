import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PibComponent } from './pib.component';

describe('PibComponent', () => {
  let component: PibComponent;
  let fixture: ComponentFixture<PibComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PibComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PibComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
