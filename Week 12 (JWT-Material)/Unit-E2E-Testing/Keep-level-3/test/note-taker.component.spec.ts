import { async, ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NoteTakerComponent } from '../src/app/note-taker/note-taker.component';
import { NotesService } from '../src/app/services/notes.service';
import { AuthenticationService } from '../src/app/services/authentication.service';
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

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/throw';

const testConfig = {
    addNotes: {
      positive: {
        id: 3,
        title: 'Read Angular 5 blog again',
        text: 'Shall do at 7 pm'
      },
      errorMessage: 'Title and Text both are required fields'
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

describe('NoteTakerComponent', () => {
  let noteTakerComponent: NoteTakerComponent;
  let fixture: ComponentFixture<NoteTakerComponent>;
  let notesService: NotesService;
  let spyTakeNotes: any;
  let errorResponse404: any;
  let positiveResponse: any = null;
  let errorMessage: string;
  let debugElement: any;
  let element: any;
  let doneButton: any;
  let inputBox: any;
  let textArea: any;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NoteTakerComponent ],
      imports: [
      FormsModule,
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
      HttpClientModule,
      BrowserAnimationsModule
      ],
      providers: [ NotesService, AuthenticationService ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NoteTakerComponent);
    noteTakerComponent = fixture.componentInstance;
    notesService = fixture.debugElement.injector.get(NotesService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(noteTakerComponent).toBeTruthy();
  });

  it('should handle 404 error on add note', fakeAsync(() => {
    errorResponse404 = testConfig.error404;
    doneButton = fixture.debugElement.nativeElement.querySelector('button');
    inputBox = fixture.debugElement.nativeElement.querySelector('input');
    textArea = fixture.debugElement.nativeElement.querySelector('textarea');
    debugElement = fixture.debugElement.query(By.css('.error-message'));

    spyTakeNotes = spyOn(notesService, 'addNote').and.returnValue(Observable.throw(errorResponse404));
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
        and <label class='error-message'>{{ errMessage }}</label> in your note-taker.component.html`);
    }
  }));

   it('should handle blank fields', fakeAsync(() => {
     errorMessage = testConfig.addNotes.errorMessage;
     doneButton = fixture.debugElement.nativeElement.querySelector('button');
     debugElement = fixture.debugElement.query(By.css('.error-message'));
     spyTakeNotes = spyOn(notesService, 'addNote').and.returnValue(Observable.of(errorMessage));
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
         `should have elements button and <label class='error-message'>{{ errMessage }}</label> in your note-taker.component.html`);
     }
  }));

  it('should handle adding of a new note', fakeAsync(() => {
    positiveResponse = testConfig.addNotes.positive;
    doneButton = fixture.debugElement.nativeElement.querySelector('button');
    inputBox = fixture.debugElement.nativeElement.querySelector('input');
    textArea = fixture.debugElement.nativeElement.querySelector('textarea');
    spyTakeNotes = spyOn(notesService, 'addNote').and.returnValue(Observable.of(positiveResponse));
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
      expect(notesService.addNote).toHaveBeenCalled();
    } else {
      expect(false).toBe(true,
       `should have elements input, textarea and button in your note-taker.component.html`);
    }
  }));
});
