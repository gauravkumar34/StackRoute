import { TestBed, async, ComponentFixture, fakeAsync, tick } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from '../src/app/app.component';
import { HeaderComponent } from '../src/app/header/header.component';
import { NotesService } from '../src/app/notes.service';
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
import { MatDividerModule } from '@angular/material/divider';
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
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/throw';

const testConfig = {
  getNotes: {
    positive: [{
      title: 'Read Angular 5 blog',
      text: 'Shall do at 6 pm'
    },
    {
      title: 'Call Ravi',
      text: 'Track the new submissions'
    }],
    negative: []
  },
  addNotes: {
    positive: {
      title: 'Read Angular 5 blog again',
      text: 'Shall do at 7 pm'
    },
    negative: {},
    errorMessage: 'Title and Text both are required fields'
  },
  error404: {
      message: 'Http failure response for http://localhost:3000/notes: 404 Not Found',
      name: 'HttpErrorResponse',
      ok: false,
      status : 404,
      statusText: 'Not Found',
      url: 'http://localhost:3000/notes'
    }
};

describe('AppComponent', () => {

  let fixture: ComponentFixture<AppComponent>;
  let notesService: NotesService;
  let spyGetNotes: any;
  let spyTakeNotes: any;
  let appComponent: AppComponent;

  let errorResponse404: any;
  let positiveResponse: Array<any>;
  let negativeResponse: Array<any>;
  let errorMessage: string;
  let addNotesPositiveResponse: any;
  let debugElement: any;
  let element: any;
  let doneButton: any;
  let inputBox: any;
  let textArea: any;


  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        HeaderComponent
      ],
      imports: [
        FormsModule,
        HttpClientModule,
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
        MatDividerModule,
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
        MatTableModule
      ],
      providers: [
        NotesService,
      ]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppComponent);
    appComponent = fixture.componentInstance;
    notesService = fixture.debugElement.injector.get(NotesService);
  });

  it('should create the app component', async(() => {
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it('should handle 404 error on get notes', fakeAsync(() => {
    errorResponse404 = testConfig.error404;
    spyGetNotes = spyOn(notesService, 'getNotes').and.returnValue(Observable.throw(errorResponse404));
    fixture.detectChanges();
    tick();
    debugElement = fixture.debugElement.query(By.css('.error-message'));
    if (debugElement) {
      element = debugElement.nativeElement;
      expect(element.textContent).toBe(errorResponse404.message,
        `should handle 'error' event of subscribe and assign 'message' property of error to the errorMessage variable`);
    } else {
      expect(false).toBe(true,
        `should have an element in your app.component.html to show your error message
        like '<label class='error-message'>{{ errMessage }}</label>'`);
    }
  }));

  it('should handle to get all notes', fakeAsync(() => {
    positiveResponse = testConfig.getNotes.positive;
    spyGetNotes = spyOn(notesService, 'getNotes').and.returnValue(Observable.of(positiveResponse));
    fixture.detectChanges();
    tick();
    debugElement = fixture.debugElement.query(By.css('.mat-card-title'));
    if (debugElement) {
      element = debugElement.nativeElement;
      expect(element.textContent).toBe(positiveResponse[0].title,
        `should get all notes from back end and display 'title' property of notes into the <mat-card-title>`);
    } else {
      expect(false).toBe(true,
        `should have an element <mat-card-title> in your app.component.html to display note 'title'`);
    }
  }));

   it('should handle to display notes on view', fakeAsync(() => {
     positiveResponse = testConfig.getNotes.positive;
     spyGetNotes = spyOn(notesService, 'getNotes').and.returnValue(Observable.of(positiveResponse));
     fixture.detectChanges();
     tick();
     debugElement = fixture.debugElement.query(By.css('.mat-card-title'));
     if (debugElement) {
       element = debugElement.nativeElement;
       expect(element.textContent).toBe(positiveResponse[0].title,
         `should display 'title' property of notes into the <mat-card-title>`);
     } else {
       expect(false).toBe(true,
         `should have an element <mat-card-title> in your app.component.html to display note 'title'`);
     }
  }));

  it('should handle if no note is created by user', fakeAsync(() => {
    negativeResponse = testConfig.getNotes.negative;
    spyGetNotes = spyOn(notesService, 'getNotes').and.returnValue(Observable.of(negativeResponse));
    fixture.detectChanges();
    tick();
    debugElement = fixture.debugElement.queryAll(By.css('.mat-card-title'));
    expect(debugElement.length).toBe(0,
      `If there is no 'note' created, then <mat-card-title> will not be rendered into the component view`);
  }));

  it('should handle 404 error on add note', fakeAsync(() => {
    errorResponse404 = testConfig.error404;
    positiveResponse = testConfig.getNotes.positive;
    doneButton = fixture.debugElement.nativeElement.querySelector('button');
    inputBox = fixture.debugElement.nativeElement.querySelector('input');
    textArea = fixture.debugElement.nativeElement.querySelector('textarea');
    debugElement = fixture.debugElement.query(By.css('.error-message'));

    spyGetNotes = spyOn(notesService, 'getNotes').and.returnValue(Observable.of(positiveResponse));
    spyTakeNotes = spyOn(notesService, 'addNote').and.returnValue(Observable.throw(errorResponse404));
    fixture.detectChanges();
    tick();
    if (inputBox !== null && textArea !== null && doneButton !== null && debugElement !== null) {
      inputBox.value = testConfig.addNotes.positive.title;
      inputBox.dispatchEvent(new Event('input'));
      textArea.value = testConfig.addNotes.positive.text;
      textArea.dispatchEvent(new Event('input'));
      doneButton.click();
      tick();
      fixture.detectChanges();
      element = debugElement.nativeElement;
      expect(element.textContent).toBe(errorResponse404.message,
        `should handle 'error' event of subscribe and assign 'message' property of error to the errorMessage variable`);
    } else {
      expect(false).toBe(true,
        `should have elements input, textarea, button
        and <label class='error-message'>{{ errMessage }}</label> in your app.component.html`);
    }
  }));

   it('should handle blank fields', fakeAsync(() => {
     errorMessage = testConfig.addNotes.errorMessage;
     positiveResponse = testConfig.getNotes.positive;
     doneButton = fixture.debugElement.nativeElement.querySelector('button');
     debugElement = fixture.debugElement.query(By.css('.error-message'));
     spyGetNotes = spyOn(notesService, 'getNotes').and.returnValue(Observable.of(positiveResponse));
     spyTakeNotes = spyOn(notesService, 'addNote').and.returnValue(Observable.of(errorMessage));
     fixture.detectChanges();
     if (doneButton !== null && debugElement !== null) {
       doneButton.click();
       tick();
       fixture.detectChanges();
       element = debugElement.nativeElement;
       expect(element.textContent).toBe(errorMessage,
         `if there is no value in title or tex input fields, assigne error message to errorMessage variable
         as 'Title and Text both are required fields'`);
     } else {
       expect(false).toBe(true,
         `should have elements button and <label class='error-message'>{{ errMessage }}</label> in your app.component.html`);
     }
  }));

  it('should handle to add a note', fakeAsync(() => {
    positiveResponse = testConfig.getNotes.positive;
    addNotesPositiveResponse = testConfig.addNotes.positive;
    doneButton = fixture.debugElement.nativeElement.querySelector('button');
    inputBox = fixture.debugElement.nativeElement.querySelector('input');
    textArea = fixture.debugElement.nativeElement.querySelector('textarea');
    spyGetNotes = spyOn(notesService, 'getNotes').and.returnValue(Observable.of(positiveResponse));
    spyTakeNotes = spyOn(notesService, 'addNote').and.returnValue(Observable.of(addNotesPositiveResponse));
    fixture.detectChanges();
    tick();
    if (inputBox !== null && textArea !== null && doneButton !== null) {
      inputBox.value = testConfig.addNotes.positive.title;
      textArea.value = testConfig.addNotes.positive.text;
      inputBox.dispatchEvent(new Event('input'));
      textArea.dispatchEvent(new Event('input'));
      doneButton.click();
      tick();
      fixture.detectChanges();
      debugElement = fixture.debugElement.queryAll(By.css('.mat-card-title'));
      if (debugElement.length > 0) {
        const lastIndex = debugElement.length - 1;
        element = debugElement[lastIndex].nativeElement;
        expect(element.textContent).toBe(addNotesPositiveResponse.title,
          `should validate newly created note is visible on view into the <mat-card-title>`);
      } else {
        expect(false).toBe(true,
          `should show recently added note title into <mat-card-title>`);
      }
    } else {
      expect(false).toBe(true,
       `should have elements input, textarea and button in your app.component.html`);
    }
  }));
});
