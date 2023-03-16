import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NoteFormationComponent } from './note-formation.component';

describe('NoteFormationComponent', () => {
  let component: NoteFormationComponent;
  let fixture: ComponentFixture<NoteFormationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NoteFormationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NoteFormationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
