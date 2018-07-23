import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterService } from './services/register.service';
import { ListComponent } from './components/list/list.component';
import { PaymentComponent } from './components/payment/payment.component';
import { CreateRegisterComponent } from './components/create-register/create-register.component';


@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    PaymentComponent,
    CreateRegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [RegisterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
