import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddContactComponent } from './components/add-contact/add-contact.component';
import { EditContactComponent } from './components/edit-contact/edit-contact.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  { path: '',component: HomeComponent },
  { path: 'home',component: HomeComponent },
  {path:'add-contact',component: AddContactComponent},
  {path:'edit-contact',component: EditContactComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
