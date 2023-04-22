import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetDishComponent } from './get-dish.component';

describe('GetDishComponent', () => {
  let component: GetDishComponent;
  let fixture: ComponentFixture<GetDishComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetDishComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetDishComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
