import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModCompanyComponent } from './mod-company.component';

describe('ModCompanyComponent', () => {
  let component: ModCompanyComponent;
  let fixture: ComponentFixture<ModCompanyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModCompanyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModCompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
