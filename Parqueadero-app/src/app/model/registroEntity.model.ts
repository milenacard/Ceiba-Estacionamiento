import { VehiculoEntity } from './vehiculoEntity.model';
export class RegistroEntity {
    id: number;
    vehiculo: VehiculoEntity;
    fechaLlegada: Date;
    fechaSalida: Date;
    totalPagar: number;
}
