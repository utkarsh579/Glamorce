import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentServiceComponent } from './appointment-service.component';

describe('AppointmentServiceComponent', () => {
  let component: AppointmentServiceComponent;
  let fixture: ComponentFixture<AppointmentServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppointmentServiceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppointmentServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
