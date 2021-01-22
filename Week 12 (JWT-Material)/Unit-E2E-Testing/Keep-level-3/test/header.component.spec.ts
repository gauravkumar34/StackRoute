import { async, ComponentFixture, TestBed, tick, fakeAsync } from '@angular/core/testing';
import { HeaderComponent } from '../src/app/header/header.component';
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
import { Router } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { Location } from '@angular/common';
import { RouterService } from '../src/app/services/router.service';
import {
  routes,
  EditNoteOpenerDummyComponent,
  LoginDummyComponent,
  ListViewDummyComponent,
  NoteViewDummyComponent,
  DashboardDummyComponent,
  AppDummyComponent} from './routes.test';

describe('HeaderComponent', () => {
  let component: HeaderComponent;
  let fixture: ComponentFixture<HeaderComponent>;
  let debugElement: any;
  let element: any;
  let router: Router;
  let location: Location;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
      HeaderComponent,
      EditNoteOpenerDummyComponent,
      LoginDummyComponent,
      ListViewDummyComponent,
      NoteViewDummyComponent,
      DashboardDummyComponent,
      AppDummyComponent
      ],
      imports: [
      RouterTestingModule.withRoutes(routes),
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
      providers: [ RouterService ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderComponent);
    router =  TestBed.get(Router);
    location = TestBed.get(Location);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the header component', () => {
    expect(component).toBeTruthy();
  });

  it('should handle navigation to list view', fakeAsync(() => {
    debugElement = fixture.debugElement.query(By.css('.switchToListView'));
    if (debugElement) {
      element = debugElement.nativeElement;
      element.click();
      tick();
      expect(location.path()).toContain('/dashboard/view/listview',
        `should navigate to list view page`);
    } else {
      expect(false).toBe(true,
        `should have an element with class 'switchToListView' in your header.component.html`);
    }
  }));

  it('should handle navigation to note view', fakeAsync(() => {
    component.isNoteView = false;
    fixture.detectChanges();
    debugElement = fixture.debugElement.query(By.css('.switchToNoteView'));
    if (debugElement) {
      element = debugElement.nativeElement;
      element.click();
      tick();
      expect(location.path()).toContain('/dashboard/view/noteview',
        `should navigate to note view page`);
    } else {
      expect(false).toBe(true,
        `should have an element with class 'switchToNoteView' in your header.component.html`);
    }
  }));



});
