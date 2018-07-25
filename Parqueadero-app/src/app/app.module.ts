import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { RegisterService } from './services/register.service';
import { ListComponent } from './components/list/list.component';
import { CreateRegisterComponent } from './components/create-register/create-register.component';
import { VehicleService } from './services/vehicle.service';;
import { CreateDepartureComponent } from './components/create-departure/create-departure.component';


@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    CreateRegisterComponent,
    CreateDepartureComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [RegisterService, VehicleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
