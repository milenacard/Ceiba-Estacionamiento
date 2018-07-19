import { RegisterService } from './../../services/register.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  constructor(private registerService: RegisterService) { }

  ngOnInit() {
  }

}
