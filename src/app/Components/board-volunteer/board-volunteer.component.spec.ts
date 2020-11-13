import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoardVolunteerComponent } from './board-volunteer.component';

describe('BoardVolunteerComponent', () => {
  let component: BoardVolunteerComponent;
  let fixture: ComponentFixture<BoardVolunteerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoardVolunteerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoardVolunteerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
