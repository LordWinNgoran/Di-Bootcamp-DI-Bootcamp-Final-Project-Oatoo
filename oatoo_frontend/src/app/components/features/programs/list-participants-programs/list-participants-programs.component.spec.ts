import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListParticipantsProgramsComponent } from './list-participants-programs.component';

describe('ListParticipantsProgramsComponent', () => {
  let component: ListParticipantsProgramsComponent;
  let fixture: ComponentFixture<ListParticipantsProgramsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListParticipantsProgramsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListParticipantsProgramsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
