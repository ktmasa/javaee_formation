import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FilmsDisplayComponent } from './films-display.component';

describe('FilmsDisplayComponent', () => {
  let component: FilmsDisplayComponent;
  let fixture: ComponentFixture<FilmsDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilmsDisplayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilmsDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
