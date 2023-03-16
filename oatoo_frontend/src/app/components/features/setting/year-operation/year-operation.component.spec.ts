import { ComponentFixture, TestBed } from '@angular/core/testing';

import { YearOperationComponent } from './year-operation.component';

describe('YearOperationComponent', () => {
  let component: YearOperationComponent;
  let fixture: ComponentFixture<YearOperationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ YearOperationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(YearOperationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
