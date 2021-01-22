import { async, ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { ListViewComponent } from '../src/app/list-view/list-view.component';
import { NotesService } from '../src/app/services/notes.service';
import { HttpClientModule } from '@angular/common/http';
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
      state: 'started'
    },
    {
      id: 3,
      title: 'Read Angular 2 blog',
      text: 'Shall do at 8 pm',
      state: 'completed'
    }
    ],
    negative: []
  }
};

describe('ListViewComponent', () => {
  let component: ListViewComponent;
  let fixture: ComponentFixture<ListViewComponent>;
  let notesService: NotesService;
  let positiveResponse: any;
  let spyGetNotes: any;
  let negativeResponse: any;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListViewComponent ],
      schemas: [ NO_ERRORS_SCHEMA ],
      imports: [ HttpClientModule ],
      providers: [ NotesService, AuthenticationService ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListViewComponent);
    component = fixture.componentInstance;
    notesService = fixture.debugElement.injector.get(NotesService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should handle get all notes', fakeAsync(() => {
    positiveResponse = testConfig.getNotes.positive;
    spyGetNotes = spyOn(notesService, 'getNotes').and.returnValue(Observable.of(positiveResponse));
    fixture.detectChanges();
    expect(component.notStartedNotes[0]).toBe(positiveResponse[0], `should populate 'notStartedNotes'`);
    expect(component.startedNotes[0]).toBe(positiveResponse[1], `should populate 'startedNotes'`);
    expect(component.completedNotes[0]).toBe(positiveResponse[2], `should populate 'completedNotes'`);
  }));

  it('should handle if no note is created by user', fakeAsync(() => {
    negativeResponse = testConfig.getNotes.negative;
    spyGetNotes = spyOn(notesService, 'getNotes').and.returnValue(Observable.of(negativeResponse));
    fixture.detectChanges();
    expect(component.notStartedNotes.length).toBe(0, `'notStartedNotes' should be 0 length if no note is created `);
    expect(component.notStartedNotes.length).toBe(0, `'startedNotes' should be 0 length if no note is created `);
    expect(component.notStartedNotes.length).toBe(0, `'completedNotes' should be 0 length if no note is created `);
  }));

});
