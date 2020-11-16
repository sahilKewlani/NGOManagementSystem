import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoardDonorComponent } from './board-donor.component';

describe('BoardDonorComponent', () => {
  let component: BoardDonorComponent;
  let fixture: ComponentFixture<BoardDonorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoardDonorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoardDonorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
