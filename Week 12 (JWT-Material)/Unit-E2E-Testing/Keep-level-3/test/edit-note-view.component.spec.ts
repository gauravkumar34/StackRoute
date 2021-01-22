import { async, ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { EditNoteViewComponent } from '../src/app/edit-note-view/edit-note-view.component';
import { FormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatSliderModule } from '@angular/material/slider';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatMenuModule } from '@angular/material/menu';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatListModule } from '@angular/material/list';
import { MatStepperModule } from '@angular/material/stepper';
import { MatTabsModule } from '@angular/material/tabs';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { Router } from '@angular/router';
import { NotesService } from '../src/app/services/notes.service';
import { RouterService } from '../src/app/services/router.service';
import { HttpClientModule } from '@angular/common/http';
import { AuthenticationService } from '../src/app/services/authentication.service';
import { Observable } from 'rxjs/Observable';
import { Location } from '@angular/common';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/throw';

const testConfig = {
  getNotes: {
    positive: [{
      id: 1,
      title: 'Read Angular 5 blog',
      text: 'Shall do at 6 pm'
    },
    {
      id: 2,
      title: 'Call Ravi',
      text: 'Track the new submissions'
    }],
  },
  error404: {
    message: 'Http failure response for http://localhost:3000/api/v1/notes: 404 Not Found',
    name: 'HttpErrorResponse',
    ok: false,
    status : 404,
    statusText: 'Not Found',
    url: 'http://localhost:3000/api/v1/notes'
  }
};

describe('EditNoteViewComponent', () => {
  let editNoteViewComponent: EditNoteViewComponent;
  let fixture: ComponentFixture<EditNoteViewComponent>;
  let notesService: NotesService;
  let errorResponse404: any;
  let doneButton: any;
  let inputBox: any;
  let textArea: any;
  let debugElement: any;
  let spyEditNote: any;
  let element: any;
  let positiveResponse: any;
  let spyGetNoteById: any;
  let routerService: any;
  let spyRouteBack: any;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        EditNoteViewComponent
      ],
      schemas: [NO_ERRORS_SCHEMA],
      imports: [
        BrowserAnimationsModule,
        MatInputModule,
        MatAutocompleteModule,
        MatCheckboxModule,
        MatDatepickerModule,
        MatFormFieldModule,
        MatInputModule,
        MatRadioModule,
        MatSelectModule,
        MatSliderModule,
        MatSlideToggleModule,
        MatMenuModule,
        MatSidenavModule,
        MatToolbarModule,
        MatCardModule,
        MatExpansionModule,
        MatGridListModule,
        MatListModule,
        MatStepperModule,
        MatTabsModule,
        MatButtonModule,
        MatButtonToggleModule,
        MatChipsModule,
        MatIconModule,
        MatProgressSpinnerModule,
        MatProgressBarModule,
        MatDialogModule,
        MatSnackBarModule,
        MatTooltipModule,
        MatPaginatorModule,
        MatSortModule,
        MatTableModule,
        FormsModule,
        HttpClientModule
      ],
      providers: [
        NotesService,
        AuthenticationService,
        RouterService,
        { provide: Location, useValue: { back: () => { } } },
        { provide: Router, useValue: {} },
        { provide: MAT_DIALOG_DATA, useValue: {note: 1} },
        { provide: MatDialogRef, useValue: { close: () => { } } }
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditNoteViewComponent);
    routerService = fixture.debugElement.injector.get(RouterService);
    notesService = fixture.debugElement.injector.get(NotesService);
    spyRouteBack = spyOn(routerService, 'routeBack').and.callFake(function(){});
    spyGetNoteById = spyOn(notesService, 'getNoteById').and.returnValue(testConfig.getNotes.positive[0]);
    fixture.detectChanges();
    editNoteViewComponent = fixture.componentInstance;
  });

  it('should create', () => {
    expect(editNoteViewComponent).toBeTruthy();
  });

  it('should handle 404 error on edit note', fakeAsync(() => {
    errorResponse404 = testConfig.error404;
    doneButton = fixture.debugElement.nativeElement.querySelector('button');
    inputBox = fixture.debugElement.nativeElement.querySelector('input');
    textArea = fixture.debugElement.nativeElement.querySelector('textarea');
    debugElement = fixture.debugElement.query(By.css('.error-message'));

    spyEditNote = spyOn(notesService, 'editNote').and.returnValue(Observable.throw(errorResponse404));
    if (inputBox !== null && textArea !== null && doneButton !== null && debugElement !== null) {
      doneButton.click();
      tick();
      fixture.detectChanges();
      element = debugElement.nativeElement;
      expect(element.textContent).toBe(errorResponse404.message,
        `should handle 'error' event of subscribe and assign 'message' property of error to
         an element with class 'error-message'`);
    } else {
      expect(false).toBe(true,
        `should have elements input, textarea, button
         and <label class='error-message'>{{ errMessage }}</label>
         in your edit-note-view.component.html`);
    }
  }));

  it('should handle edit note', fakeAsync(() => {
    positiveResponse = testConfig.getNotes.positive[0];
    doneButton = fixture.debugElement.nativeElement.querySelector('button');
    inputBox = fixture.debugElement.nativeElement.querySelector('input');
    textArea = fixture.debugElement.nativeElement.querySelector('textarea');
    spyEditNote = spyOn(notesService, 'editNote').and.returnValue(Observable.of(positiveResponse));
    fixture.detectChanges();
    tick();
    if (inputBox !== null && textArea !== null && doneButton !== null) {
      doneButton.click();
      tick();
      fixture.detectChanges();
      expect(notesService.editNote).toHaveBeenCalled();
    } else {
      expect(false).toBe(true,
       `should have elements input, textarea and button in your
        note-taker.component.html`);
    }
  }));
});
