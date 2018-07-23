import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LocalisationCounterComponent } from './localisation-counter.component';

describe('LocalisationCounterComponent', () => {
  let component: LocalisationCounterComponent;
  let fixture: ComponentFixture<LocalisationCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LocalisationCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LocalisationCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
