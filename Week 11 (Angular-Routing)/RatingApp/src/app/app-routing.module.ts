import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { SearchMoviesComponent } from './components/search-movies/search-movies.component';

const routes: Routes = [
  {path:'',component:DashboardComponent},
  {path:'search-movies',component:SearchMoviesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
