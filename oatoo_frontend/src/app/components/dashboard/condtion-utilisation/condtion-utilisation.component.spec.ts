import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CondtionUtilisationComponent } from './condtion-utilisation.component';

describe('CondtionUtilisationComponent', () => {
  let component: CondtionUtilisationComponent;
  let fixture: ComponentFixture<CondtionUtilisationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CondtionUtilisationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CondtionUtilisationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
