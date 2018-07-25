import { AppComponent } from './app.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ListComponent } from './components/list/list.component';
import { CreateRegisterComponent } from './components/create-register/create-register.component';
import { CreateDepartureComponent } from './components/create-departure/create-departure.component';

const routes: Routes = [
    {path: '', redirectTo: '/appComponent', pathMatch: 'full'},
    {path: 'AppComponent', component: AppComponent},
    {path: 'listComponent', component: ListComponent},
    {path: 'createRegisterComponent', component: CreateRegisterComponent},
    {path: 'createDepartureComponent', component: CreateDepartureComponent},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule { }
