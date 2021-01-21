import { async, ComponentFixture, TestBed, fakeAsync, tick, inject} from '@angular/core/testing';
import { Router } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Location } from '@angular/common';
import { By } from '@angular/platform-browser';
import { FormsModule, FormControl } from '@angular/forms';
import { NgForm } from '@angular/forms';
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
import { AuthenticationService } from '../src/app/services/authentication.service';
import { RouterService } from '../src/app/services/router.service';
import { LoginComponent } from '../src/app/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { ReactiveFormsModule } from '@angular/forms';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/throw';



const testConfig = {
  error404: {
    message: 'Http failure response for http://localhost:3000/auth/v1: 404 Not Found',
    name: 'HttpErrorResponse',
    ok: false,
    status : 404,
    statusText: 'Not Found',
    url: 'http://localhost:3000/auth/v1'
  },
  error403: {
    error: {message: 'Unauthorized'},
    message: 'Http failure response for http://localhost:3000/auth/v1/: 403 Forbidden',
    name: 'HttpErrorResponse',
    ok: false,
    status: 403,
    statusText: 'Forbidden',
    url: 'http://localhost:3000/auth/v1/'
  },
  positive: {
    token: 'token123'
  }
};

describe('LoginComponent', () => {
  let authenticationService: AuthenticationService;
  let positiveResponse: any;
  let loginComponent: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let spyAuthenticateUser: any;
  let spySetBearerToken: any;
  let spyRouteToDashboard: any;
  const routerSpy: any = {};
  let location: Location;
  let routerService: any;
  let errorMessage: any;
  let debugElement: any;
  let element: any;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
      LoginComponent
      ],
      imports: [
      FormsModule,
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
      HttpClientModule,
      ReactiveFormsModule
      ],
      providers: [
      AuthenticationService,
      RouterService,
      { provide: Location, useValue: {} },
      { provide: Router, useValue: routerSpy }
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    location = TestBed.get(Location);
    loginComponent = fixture.componentInstance;
    authenticationService = fixture.debugElement.injector.get(AuthenticationService);
    routerService = fixture.debugElement.injector.get(RouterService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(loginComponent).toBeTruthy();
  });

  it('should handle to login into the system', fakeAsync(() => {
    positiveResponse = testConfig.positive;
    spyAuthenticateUser = spyOn(authenticationService, 'authenticateUser').and.returnValue(Observable.of(positiveResponse));
    const token = testConfig.positive.token;
    spySetBearerToken = spyOn(authenticationService, 'setBearerToken').and.callFake(function(){
      localStorage.setItem('bearerToken', token);
    });
    spyRouteToDashboard = spyOn(routerService, 'routeToDashboard').and.callFake(function(){});
    const username = new FormControl('stranger');
    loginComponent.username = username;
    const password = new FormControl('password');
    loginComponent.password = password;
    loginComponent.loginSubmit();
    expect(localStorage.getItem('bearerToken')).toBe(token, 'should get token from local storage');
  }));

  it('should handle wrong login and password', fakeAsync(() => {
    errorMessage = testConfig.error403;
    loginComponent.submitMessage = ' ';
    fixture.detectChanges();
    debugElement = fixture.debugElement.query(By.css('.error-message'));
    spyAuthenticateUser = spyOn(authenticationService, 'authenticateUser').and.returnValue(Observable.throw(errorMessage));

    const username = new FormControl('stranger');
    loginComponent.username = username;
    const password = new FormControl('password');
    loginComponent.password = password;
    loginComponent.loginSubmit();

    tick();
    fixture.detectChanges();
    if (debugElement !== null) {
      element = debugElement.nativeElement;
      expect(element.textContent).toBe(errorMessage.error.message,
        `should store 'err.error.message' in a varibale 'submitMessage' to show error on login page`);
    } else {
      expect(false).toBe(true,
        `should have an element  as <strong *ngIf="submitMessage" class="error-message">{{submitMessage}}</strong>
        in your login.component.html to show server errror response`);
    }
  }));


  it('should handle 404 error on login', fakeAsync(() => {
    errorMessage = testConfig.error404;
    loginComponent.submitMessage = ' ';
    fixture.detectChanges();
    debugElement = fixture.debugElement.query(By.css('.error-message'));
    spyAuthenticateUser = spyOn(authenticationService, 'authenticateUser').and.returnValue(Observable.throw(errorMessage));

    const username = new FormControl('stranger');
    loginComponent.username = username;
    const password = new FormControl('password');
    loginComponent.password = password;
    loginComponent.loginSubmit();

    tick();
    fixture.detectChanges();
    if (debugElement !== null) {
      element = debugElement.nativeElement;
      expect(element.textContent).toBe(errorMessage.message,
        `should store 'err.message' in a varibale 'submitMessage' to show error on login page`);
    } else {
      expect(false).toBe(true,
        `should have an element  as <strong *ngIf="submitMessage" class="error-message">{{submitMessage}}</strong>
        in your login.component.html to show server errror response`);
    }
  }));
});
