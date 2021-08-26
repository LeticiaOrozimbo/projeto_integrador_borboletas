import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IsobreNosComponent } from './isobre-nos.component';

describe('IsobreNosComponent', () => {
  let component: IsobreNosComponent;
  let fixture: ComponentFixture<IsobreNosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IsobreNosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IsobreNosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
