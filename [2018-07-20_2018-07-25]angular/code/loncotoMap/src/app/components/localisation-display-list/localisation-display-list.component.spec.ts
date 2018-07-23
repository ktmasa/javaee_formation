import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LocalisationDisplayListComponent } from './localisation-display-list.component';

describe('LocalisationDisplayListComponent', () => {
  let component: LocalisationDisplayListComponent;
  let fixture: ComponentFixture<LocalisationDisplayListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LocalisationDisplayListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LocalisationDisplayListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
