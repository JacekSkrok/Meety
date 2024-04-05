import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MeetPageComponent } from './meet-page.component';

describe('MeetPageComponent', () => {
  let component: MeetPageComponent;
  let fixture: ComponentFixture<MeetPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MeetPageComponent]
    });
    fixture = TestBed.createComponent(MeetPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
