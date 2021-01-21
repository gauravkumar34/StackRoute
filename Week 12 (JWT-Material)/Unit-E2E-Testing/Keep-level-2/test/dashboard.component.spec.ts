import { async, fakeAsync, tick, ComponentFixture, TestBed } from '@angular/core/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from '../src/app/dashboard/dashboard.component';
import { NotesService } from '../src/app/services/notes.service';
import { AuthenticationService } from '../src/app/services/authentication.service';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';


const testConfig = {
  getNotes: {
    positive: [{
      id: 1,
      title: 'Read Angular 5 blog',
      text: 'Shall do at 6 pm',
      state: 'not-started'
    },
    {
      id: 2,
      title: 'Call Ravi',
      text: 'Track the new submissions',
      state: 'not-started'
    }],
    negative: []
  }
};

describe('DashboardComponent', () => {
  let component: DashboardComponent;
  let fixture: ComponentFixture<DashboardComponent>;
  let notesService: NotesService;
  let spyGetNotes: any;
  let positiveResponse: Array<any>;
  let negativeResponse: Array<any>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashboardComponent ],
      imports: [ HttpClientModule ],
      schemas: [NO_ERRORS_SCHEMA],
      providers: [
        NotesService,
        AuthenticationService
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    notesService = TestBed.get(NotesService);
  });

  it('should create', () => {
    fixture = TestBed.createComponent(DashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    expect(component).toBeTruthy();
  });


  it('should handle to get all notes', fakeAsync(() => {
    positiveResponse = testConfig.getNotes.positive;
    spyGetNotes = spyOn(notesService, 'getNotes').and.returnValue(Observable.of(positiveResponse));
    fixture = TestBed.createComponent(DashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();

    expect(component.notes).toBe(positiveResponse, `should get all notes from back end`);
  }));

  it('should handle if no note is created by user', fakeAsync(() => {
    negativeResponse = testConfig.getNotes.negative;
    spyGetNotes = spyOn(notesService, 'getNotes').and.returnValue(Observable.of(negativeResponse));
    fixture = TestBed.createComponent(DashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();

    expect(component.notes.length).toBe(0,
      `If there is no 'note' created, notes array length should be 0`);
  }));
});
