import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAllDishesComponent } from './show-all-dishes.component';

describe('ShowAllDishesComponent', () => {
  let component: ShowAllDishesComponent;
  let fixture: ComponentFixture<ShowAllDishesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowAllDishesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowAllDishesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
