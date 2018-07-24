import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from '../../../node_modules/rxjs';

import { VehiculoEntity } from './../model/vehiculoEntity.model';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {
  constructor(private http: HttpClient ) { }
  public findVehicle(placa: string): Observable<VehiculoEntity> {
    return this.http.get<VehiculoEntity>('http://localhost:8090/vehiculo/find?placa=' + placa);
  }
}
