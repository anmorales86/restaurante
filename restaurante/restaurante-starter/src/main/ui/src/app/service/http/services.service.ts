import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {  BaseService } from './base.service';


const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' })};

@Injectable()
export class ServicesService extends BaseService {

    url: string = '';

    constructor(protected httpClient: HttpClient, protected router: Router) {
        super(httpClient, router);
    }

    getClients(): Observable<any> {
        console.log('urlBase -> ', this.getBaseUrl());
        const path = this.url = this.getBaseUrl() + '/getClients';
        console.log('path -> ', path);
        return this.httpClient.get(path);
    }

    addClient(clientRequest: any): Observable<any> {
            console.log('urlBase -> ', this.getBaseUrl());
            const path = this.url = this.getBaseUrl() + '/addClient';
            console.log('path -> ', path);
            console.log('JSON.stringify(addClient) -> ', JSON.stringify(clientRequest));
            return this.httpClient.post(path, JSON.stringify(clientRequest), httpOptions);
    }

    getChefs(): Observable<any> {
        console.log('urlBase -> ', this.getBaseUrl());
        const path = this.url = this.getBaseUrl() +  '/getChefs';
        console.log('path -> ', path);
        return this.httpClient.get(path);
    }

    addChef(chefRequest: any): Observable<any> {
            console.log('urlBase -> ', this.getBaseUrl());
            const path = this.url = this.getBaseUrl() + '/addChef';
            console.log('path -> ', path);
            console.log('JSON.stringify(chefRequest) -> ', JSON.stringify(chefRequest));
            return this.httpClient.post(path, JSON.stringify(chefRequest), httpOptions);
    }

    getWaiters(): Observable<any> {
        console.log('urlBase -> ', this.getBaseUrl());
        const path = this.url = this.getBaseUrl() + '/getWaiters';
        console.log('path -> ', path);
        return this.httpClient.get(path);
    }

    addWaiter(chefRequest: any): Observable<any> {
            console.log('urlBase -> ', this.getBaseUrl());
            const path = this.url = this.getBaseUrl() + '/addWaiter';
            console.log('path -> ', path);
            console.log('JSON.stringify(chefRequest) -> ', JSON.stringify(chefRequest));
            return this.httpClient.post(path, JSON.stringify(chefRequest), httpOptions);
    }

    getTables(): Observable<any> {
        console.log('urlBase -> ', this.getBaseUrl());
        const path = this.url = this.getBaseUrl() + '/getTables';
        console.log('path -> ', path);
        return this.httpClient.get(path);
    }

    addTable(tableRequest: any): Observable<any> {
            console.log('urlBase -> ', this.getBaseUrl());
            const path = this.url = this.getBaseUrl() + '/addTable';
            console.log('path -> ', path);
            console.log('JSON.stringify(tableRequest) -> ', JSON.stringify(tableRequest));
            return this.httpClient.post(path, JSON.stringify(tableRequest), httpOptions);
    }

    addInvoicee(invoiceRequest: any): Observable<any> {
        console.log('urlBase -> ', this.getBaseUrl());
        const path = this.url = this.getBaseUrl() + '/addInvoice';
        console.log('path -> ', path);
        console.log('JSON.stringify(invoiceRequest) -> ', JSON.stringify(invoiceRequest));
        return this.httpClient.post(path, JSON.stringify(invoiceRequest), httpOptions);
    }

    getReportWaiter(): Observable<any> {
        console.log('urlBase -> ', this.getBaseUrl());
        const path = this.url = this.getBaseUrl() + '/getReportWaiter';
        console.log('path -> ', path);
        return this.httpClient.get(path);
    }

    getReportClient(): Observable<any> {
        console.log('urlBase -> ', this.getBaseUrl());
        const path = this.url = this.getBaseUrl() + '/getReportClient';
        console.log('path -> ', path);
        return this.httpClient.get(path);
    }

}
