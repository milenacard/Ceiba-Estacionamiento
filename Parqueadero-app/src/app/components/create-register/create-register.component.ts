import { VehicleService } from './../../services/vehicle.service';
import { Component, OnInit } from '@angular/core';

import { VehiculoEntity } from './../../model/vehiculoEntity.model';
import { RegistroEntity } from './../../model/registroEntity.model';

@Component({
  selector: 'app-create-register',
  templateUrl: './create-register.component.html',
  styleUrls: ['./create-register.component.css']
})
export class CreateRegisterComponent implements OnInit {
  private vehicle: VehiculoEntity = new VehiculoEntity();
  private register: RegistroEntity;
  private placa: string;

  constructor(private vehicleService: VehicleService) {
    this.register = new RegistroEntity();
  }

  ngOnInit() {
  }

  private findVehicle () {
    this.vehicleService.findVehicle(this.placa.toUpperCase()).subscribe(res => {
      this.vehicle = res;
    });
  }

}
