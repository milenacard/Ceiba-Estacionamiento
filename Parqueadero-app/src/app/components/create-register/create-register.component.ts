import { RegistroEntity } from './../../model/registroEntity.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-register',
  templateUrl: './create-register.component.html',
  styleUrls: ['./create-register.component.css']
})
export class CreateRegisterComponent implements OnInit {

  private register: RegistroEntity;

  constructor() {
    this.register = new RegistroEntity();
  }

  ngOnInit() {
  }

}
