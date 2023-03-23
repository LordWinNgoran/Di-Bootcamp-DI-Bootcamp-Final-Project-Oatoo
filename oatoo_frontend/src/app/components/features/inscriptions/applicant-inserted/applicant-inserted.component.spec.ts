import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplicantInsertedComponent } from './applicant-inserted.component';

describe('ApplicantInsertedComponent', () => {
  let component: ApplicantInsertedComponent;
  let fixture: ComponentFixture<ApplicantInsertedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApplicantInsertedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApplicantInsertedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
