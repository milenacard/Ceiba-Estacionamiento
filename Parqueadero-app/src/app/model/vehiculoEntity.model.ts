import { TipoVehiculoEntity } from './tipoVehiculoEntity.model';

export class VehiculoEntity {
    placa: string;
    id_tipoVehiculo: TipoVehiculoEntity;
    cilindraje: number;
}
