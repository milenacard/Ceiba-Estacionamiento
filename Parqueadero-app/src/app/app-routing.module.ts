import { ListComponent } from './components/list/list.component';
import { AppComponent } from './app.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateRegisterComponent } from './components/create-register/create-register.component';

const routes: Routes = [
    {path: '', redirectTo: '/appComponent', pathMatch: 'full'},
    {path: 'AppComponent', component: AppComponent},
    {path: 'listComponent', component: ListComponent},
    {path: 'createRegisterComponent', component: CreateRegisterComponent},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule { }
