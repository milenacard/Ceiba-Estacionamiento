import { TipoVehiculoEntity } from './../../model/tipoVehiculoEntity.model';
import { VehicleService } from './../../services/vehicle.service';
import { Component, OnInit } from '@angular/core';

import { VehiculoEntity } from './../../model/vehiculoEntity.model';
import { RegistroEntity } from './../../model/registroEntity.model';
import { RegisterService } from '../../services/register.service';

@Component({
  selector: 'app-create-register',
  templateUrl: './create-register.component.html',
  styleUrls: ['./create-register.component.css']
})
export class CreateRegisterComponent implements OnInit {
  private sucess = true;
  private message: string;
  private vehicle: VehiculoEntity = new VehiculoEntity();
  private tipoVehiculo: TipoVehiculoEntity = new TipoVehiculoEntity();
  private register: RegistroEntity;
  private placa: string;

  constructor(private vehicleService: VehicleService,  private registerService: RegisterService) {
    this.register = new RegistroEntity();
  }

  ngOnInit() {
    this.clearVehicle();
  }

  private clearVehicle() {
    this.tipoVehiculo.id = 0;
    this.vehicle.tipoVehiculo = this.tipoVehiculo;
    this.vehicle.cilindraje = null;
  }

  private findVehicle () {
    this.vehicleService.findVehicle(this.vehicle.placa.toUpperCase()).subscribe(
      res => {
        this.sucess = true;
        this.vehicle = res;
      },
      err => {
        this.sucess = false;
        this.message = err.error.message;
      }
    );
  }

  private registerVehicle() {
    this.sucess = true;
    this.register.vehiculo = this.vehicle;
    if (this.register.vehiculo.cilindraje == null) {
      this.register.vehiculo.cilindraje = 0;
    }
    this.registerService.createRegister(this.register).subscribe(
      res => {
        alert('El vehiculo se ha creado existosamente');
        console.log(this.register);
      },
      err => {
        this.message = err.error.message;
      }
    );
  }
}
