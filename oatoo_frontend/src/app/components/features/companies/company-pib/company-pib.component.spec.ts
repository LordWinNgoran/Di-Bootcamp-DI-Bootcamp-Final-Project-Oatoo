import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyPibComponent } from './company-pib.component';

describe('CompanyPibComponent', () => {
  let component: CompanyPibComponent;
  let fixture: ComponentFixture<CompanyPibComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompanyPibComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CompanyPibComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
