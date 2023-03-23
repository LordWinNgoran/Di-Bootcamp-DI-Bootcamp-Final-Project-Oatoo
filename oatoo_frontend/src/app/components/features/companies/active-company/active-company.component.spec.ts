import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActiveCompanyComponent } from './active-company.component';

describe('ActiveCompanyComponent', () => {
  let component: ActiveCompanyComponent;
  let fixture: ComponentFixture<ActiveCompanyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActiveCompanyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActiveCompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
