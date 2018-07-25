import swal, { SweetAlertOptions } from 'sweetalert2';

export class HandleMessageUtil {

    constructor() {}

    successMessage(mensaje: string) {
        swal({
            title: 'Excelente!',
            text: mensaje,
            type: 'success',
            confirmButtonColor: '#0032a1',
            confirmButtonText: 'Aceptar'
          }).then(function () {
            location.toString();
          });
    }

    errorMessage(mensaje: string) {
        swal({
            title: 'Error!',
            text: mensaje,
            type: 'error',
            confirmButtonColor: '#0032a1',
             confirmButtonText: 'Aceptar'
          }).then(function () {
            location.toString();
        });
      }

    alertMessage(mensaje: string) {
        swal({
          title: 'Atención!',
          text: mensaje,
          type: 'warning',
          confirmButtonColor: '#0032a1',
          confirmButtonText: 'Aceptar'
        });
      }
}
