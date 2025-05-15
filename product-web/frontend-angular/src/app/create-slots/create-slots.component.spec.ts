import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSlotsComponent } from './create-slots.component';

describe('CreateSlotsComponent', () => {
  let component: CreateSlotsComponent;
  let fixture: ComponentFixture<CreateSlotsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateSlotsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateSlotsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
