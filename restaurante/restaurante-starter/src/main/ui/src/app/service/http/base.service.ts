import { Router } from '@angular/router';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

export abstract class BaseService {

    base_url_general: string = environment.rest_url;

    constructor(protected httpClient: HttpClient, protected router: Router) {

    }

    public setBaseUrl(urlEntrada: string) {
        this.base_url_general = urlEntrada;
    }

    public getBaseUrl() {
        console.log('this.base_url_general-> ', this.base_url_general);
        return this.base_url_general;
    }

    public catchAuthError(res: HttpErrorResponse) {
        return Observable.throw(res);
    }
}