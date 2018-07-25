import swal, { SweetAlertOptions } from 'sweetalert2';
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
  private tipoVehiculoSeleccionado: TipoVehiculoEntity;
  private listTipoVehiculo: Array<TipoVehiculoEntity>;
  private register: RegistroEntity;
  private placa: string;

  constructor(private vehicleService: VehicleService, private registerService: RegisterService) {
    this.register = new RegistroEntity();
    this.listTipoVehiculo = new Array<TipoVehiculoEntity>();
    this.tipoVehiculoSeleccionado = new TipoVehiculoEntity();
  }

  ngOnInit() {
    this.clearVehicle();
    this.buildTipoVehiculo();
  }

  private buildTipoVehiculo() {

    this.listTipoVehiculo = [
      { codigo: 1, nombre: 'Moto' },
      { codigo: 2, nombre: 'Carro' }
    ];
  }

  private clearVehicle() {
    this.vehicle.cilindraje = null;
  }

  private findVehicle() {
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
    this.vehicle.tipoVehiculo = this.tipoVehiculoSeleccionado;
    this.register.vehiculo = this.vehicle;
    if (this.register.vehiculo.cilindraje == null) {
      this.register.vehiculo.cilindraje = 0;
    }
    this.registerService.createRegister(this.register).subscribe(
      res => {
        swal({
          title: 'Excelente!',
          text: 'se creo exitosamente',
          type: 'success',
          confirmButtonColor: '#0032a1',
          confirmButtonText: 'Aceptar'
        }).then(function () {
          location.toString();
        });
      },
      err => {
        this.message = err.error.message;
      }
    );
  }
}
