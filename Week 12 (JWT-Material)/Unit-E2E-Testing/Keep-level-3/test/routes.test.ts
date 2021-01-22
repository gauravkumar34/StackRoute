import { Component, NgModule, Type, Injectable } from '@angular/core';
import { ReplaySubject } from 'rxjs/ReplaySubject';
import { convertToParamMap, ParamMap, Params, Routes } from '@angular/router';
import { EditNoteViewComponent } from '../src/app/edit-note-view/edit-note-view.component';
import { FormsModule } from '@angular/forms';
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
import {CommonModule} from '@angular/common';

@Component({
  template: `Login Component`
})
export class LoginDummyComponent {
}

@Component({
  template: `<router-outlet></router-outlet>
<router-outlet name="noteEditOutlet"></router-outlet>`
})
export class DashboardDummyComponent {
}

@Component({
  template: `NoteView Component`
})
export class NoteViewDummyComponent {
}

@Component({
  template: `ListView Component`
})
export class ListViewDummyComponent {
}

@Component({
  template: `EditNoteOpener Component`
})
export class EditNoteOpenerDummyComponent {
}

@Component({
  template: `<router-outlet></router-outlet>`
})
export class AppDummyComponent {
}


@Injectable()
export class MockRouterService {
  constructor() {  }
}

@NgModule({
  declarations: [EditNoteViewComponent],
  entryComponents: [EditNoteViewComponent],
  imports: [
  CommonModule,
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
  ]
})
export class FakeTestDialogModule {

}

export const routes: Routes = [
{ path: 'login', component: LoginDummyComponent },
{ path: 'dashboard', component: DashboardDummyComponent,
children: [
{path: 'view/noteview', component: NoteViewDummyComponent},
{path: 'view/listview', component: ListViewDummyComponent},
{path: '', redirectTo: 'view/noteview', pathMatch: 'full'},
{path: 'note/:noteId/edit', component: EditNoteOpenerDummyComponent, outlet: 'noteEditOutlet'}
]}];
