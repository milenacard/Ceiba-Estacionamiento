import { VehiculoEntity } from './vehiculoEntity.model';
export class RegistroEntity {
    id: number;
    id_vehiculo: VehiculoEntity;
    fechaLlegada: Date;
    fechaSalida: Date;
    totalPagar: number;
}
