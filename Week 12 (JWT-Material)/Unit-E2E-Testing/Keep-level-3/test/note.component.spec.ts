import { async, ComponentFixture, TestBed, tick, fakeAsync } from '@angular/core/testing';
import { RouterService } from '../src/app/services/router.service';
import { NoteComponent } from '../src/app/note/note.component';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { Location } from '@angular/common';
import { RouterTestingModule } from '@angular/router/testing';
import { By } from '@angular/platform-browser';
import { Router } from '@angular/router';
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
import {
  routes,
  EditNoteOpenerDummyComponent,
  LoginDummyComponent,
  ListViewDummyComponent,
  NoteViewDummyComponent,
  DashboardDummyComponent,
  AppDummyComponent} from './routes.test';


const testConfig = {
  getNotes: {
    positive: {
      id: 1,
      title: 'Read Angular 5 blog again',
      text: 'Shall do at 7 pm',
      state: 'not-started'
      },
    negative: [],
    editNotePath: '/dashboard/(noteEditOutlet:note/1/edit)'
  }
};


describe('NoteComponent', () => {
  let noteComponent: NoteComponent;
  let fixture: ComponentFixture<NoteComponent>;
  let location: Location;
  let debugElement: any;
  let element: any;
  let router: Router;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
      NoteComponent,
      EditNoteOpenerDummyComponent,
      LoginDummyComponent,
      ListViewDummyComponent,
      NoteViewDummyComponent,
      DashboardDummyComponent,
      AppDummyComponent],
      schemas: [NO_ERRORS_SCHEMA],
      imports: [
      RouterTestingModule.withRoutes(routes),
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
      MatTableModule
      ],
      providers: [ RouterService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    location = TestBed.get(Location);
    router = TestBed.get(Router);
    fixture = TestBed.createComponent(NoteComponent);
    noteComponent = fixture.componentInstance;
    noteComponent.note = testConfig.getNotes.positive;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(noteComponent).toBeTruthy();
  });

  it('should handle to display notes on view', () => {
    debugElement = fixture.debugElement.query(By.css('.mat-card-title'));
    if (debugElement) {
      element = debugElement.nativeElement;
      expect(element.textContent).toBe(testConfig.getNotes.positive.title,
        `should display 'title' property of notes into the <mat-card-title>`);
     } else {
      expect(false).toBe(true,
        `should have an element <mat-card-title> in your note.component.html to display note 'title'`);
     }
  });

  it('should handle click event of card and navigate to edit note route', fakeAsync(() => {
    debugElement = fixture.debugElement.query(By.css('.mat-card'));
    if (debugElement) {
      element = debugElement.nativeElement;
      element.click();
      tick();
      expect(location.path()).toBe(testConfig.getNotes.editNotePath,
        `should navigate to 'edit note' route and url should be as '/dashboard/(noteEditOutlet:note/1/edit')`);
     } else {
      expect(false).toBe(true,
        `should have an element <mat-card> in your note.component.html`);
     }
  }));


});
