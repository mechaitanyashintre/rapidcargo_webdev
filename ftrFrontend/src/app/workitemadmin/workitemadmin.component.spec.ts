import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkitemadminComponent } from './workitemadmin.component';

describe('WorkitemadminComponent', () => {
  let component: WorkitemadminComponent;
  let fixture: ComponentFixture<WorkitemadminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WorkitemadminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkitemadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
