import { Injectable } from '@angular/core';

import { HttpErrorResponse } from '@angular/common/http';

import { ToastrService } from 'ngx-toastr';

import { Router } from '@angular/router';
import { ErrorResponse } from 'src/app/model/errorResponse.model';


declare var jQuery: any;
declare var $: any;

/**
 * Este servicio es para la creación de varios métodos
 * que pueden ser utilizados en toda la aplicación
 * Created by Anderson.Quintero
 * Date: 02/09/2018
 */
@Injectable()
export class UtilService {

    resetErrorResponse(err: HttpErrorResponse) {
        return new ErrorResponse(err);
    }

    showSuccess(toastrService: ToastrService, message, title) {
        toastrService.info(message, title);
      }
      showErrors(toastrService: ToastrService, message, title) {
        toastrService.error(message, title);
      }

    
    esNumero(texto) {
        if (!/^([0-9])*$/.test(texto)) {
            return false; 
        }
        return true;
    }  
    

    
    /**
     * Method to save log the answer when ocurried a error
     * @param err   Error of HttpErrorResponse
     */
    captureError(err: HttpErrorResponse) {
        if (err.error instanceof Error) {
            console.log('An error occurred:', err.error.message);
        } else {
            console.log('Backend returned status code: ', err.status);
            console.log('Response body:', err.error);
        }
    }
}
