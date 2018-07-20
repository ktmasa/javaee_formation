import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FilmsCounterComponent } from './films-counter.component';

describe('FilmsCounterComponent', () => {
  let component: FilmsCounterComponent;
  let fixture: ComponentFixture<FilmsCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilmsCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilmsCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
