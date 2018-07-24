import { VehiculoEntity } from './../../model/vehiculoEntity.model';
import { RegistroEntity } from './../../model/registroEntity.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-register',
  templateUrl: './create-register.component.html',
  styleUrls: ['./create-register.component.css']
})
export class CreateRegisterComponent implements OnInit {

  private register: RegistroEntity;
  //private vehicle_ VehiculoEntity;

  constructor() {
    this.register = new RegistroEntity();
  }

  ngOnInit() {
  }

  private findVehicle() {

  }

}
