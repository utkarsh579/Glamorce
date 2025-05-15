import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeesSlotsComponent } from './employees-slots.component';

describe('EmployeesSlotsComponent', () => {
  let component: EmployeesSlotsComponent;
  let fixture: ComponentFixture<EmployeesSlotsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeesSlotsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmployeesSlotsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
