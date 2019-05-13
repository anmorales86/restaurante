import { Component, OnInit, ViewChild } from '@angular/core';
import { UtilService } from 'src/app/service/http/util.service';
import { ServicesService } from 'src/app/service/http/services.service';
import { ClientDto } from 'src/app/model/client/clientDto.model';
import { HttpErrorResponse } from '@angular/common/http';
import { ErrorResponse } from 'src/app/model/errorResponse.model';
import { ChefDto } from 'src/app/model/chef/chefDto.model';
import { WaiterDto } from 'src/app/model/waiter/waiterDto.model';
import { TableRestDto } from 'src/app/model/table/tableRest.model';

import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { InvoiceDetailDto } from 'src/app/model/invoice/invoiceDetailDto.model';
import { InvoiceDto } from 'src/app/model/invoice/invoiceDto.model';
import { ToastrService } from 'ngx-toastr';

declare var jQuery: any;
declare var $: any;

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {

  clientDtoList: ClientDto[];
  clientDto: ClientDto = new ClientDto();
  chefDtoList: ChefDto[];
  chefDto: ChefDto = new ChefDto();
  waiterDtoList: WaiterDto[];
  waiterDto: WaiterDto = new WaiterDto();
  tableRestDtoList: TableRestDto[];
  tableRestDtoShowList: TableRestDto[];
  tableRestDto: TableRestDto = new TableRestDto();

  invoiceDetailDtoList: InvoiceDetailDto[] = [];
  invoiceDetailDto: InvoiceDetailDto = new InvoiceDetailDto();
  errorResponse: ErrorResponse;

  client: string;
  chef: string;
  waiter: string;
  tableRest: string;
  personNumbers: string;
  plate: string;
  value: number;
  valueTotal: number;
  invoiceDto: InvoiceDto = new InvoiceDto();

  displayedColumns: string[] = ['Plate', 'Value'];
  dataSource = new MatTableDataSource([]);

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private utilService: UtilService,
              private toastrService: ToastrService,
              private servicesService: ServicesService) { }

  ngOnInit() {
    this.valueTotal = 0;
    this.client = '';
    this.chef = '';
    this.waiter = '';
    this.tableRest = '';
    this.personNumbers = '';
    this.plate = '';
    this.value = 0;
    this.getClientList();
    this.getChefList();
    this.getWaiterList();
    this.getTableList();
    this.invoiceDetailDtoList = [];
    this.dataSource.data = [];
  }

  getTableList() {
    this.servicesService.getTables().subscribe((val: TableRestDto[]) => {
      console.log('VAL -> ', val);
      this.tableRestDtoList = val;
      if (this.tableRestDtoList !== null) {
        console.log('this.tableRestDtoList -> ', this.tableRestDtoList);
        
      }  
      
      
      //setTimeout(() => { this.spinner.hide(); }, 500);

  },
  (err: HttpErrorResponse) => {
          //setTimeout(() => this.spinner.hide(), 300);
          this.utilService.captureError(err);
          this.errorResponse = this.utilService.resetErrorResponse(err);
          setTimeout(() => $('#modalError').click(), 300);
      }
  );
  }

  personNumberSelected() {
    
    
    this.getTableList();
    this.tableRestDtoShowList = this.tableRestDtoList.filter(data=>data.maxComensaNumber >= Number(this.personNumbers));
  }

  getWaiterList() {
    this.servicesService.getWaiters().subscribe((val: WaiterDto[]) => {
      console.log('VAL -> ', val);
      this.waiterDtoList = val;
      if (this.waiterDtoList !== null) {
          console.log('this.waiterDtoList -> ', this.waiterDtoList);
          
      }
      
      
      //setTimeout(() => { this.spinner.hide(); }, 500);

  },
  (err: HttpErrorResponse) => {
          //setTimeout(() => this.spinner.hide(), 300);
          this.utilService.captureError(err);
          this.errorResponse = this.utilService.resetErrorResponse(err);
          setTimeout(() => $('#modalError').click(), 300);
      }
  );
  }

  getClientList() {
    this.servicesService.getClients().subscribe((val: ClientDto[]) => {
      console.log('VAL -> ', val);
      this.clientDtoList = val;
      console.log('this.clientDto -> ', this.clientDtoList);
      
      
      //setTimeout(() => { this.spinner.hide(); }, 500);

  },
  (err: HttpErrorResponse) => {
          //setTimeout(() => this.spinner.hide(), 300);
          this.utilService.captureError(err);
          this.errorResponse = this.utilService.resetErrorResponse(err);
          setTimeout(() => $('#modalError').click(), 300);
      }
  );
  }

  getChefList() {
    this.servicesService.getChefs().subscribe((val: ChefDto[]) => {
      console.log('VAL -> ', val);
      this.chefDtoList = val;
      if (this.chefDtoList !== null) {
        console.log('this.chefDtoList -> ', this.chefDtoList);
        
      }  
      
      
      //setTimeout(() => { this.spinner.hide(); }, 500);

  },
  (err: HttpErrorResponse) => {
          //setTimeout(() => this.spinner.hide(), 300);
          this.utilService.captureError(err);
          this.errorResponse = this.utilService.resetErrorResponse(err);
          setTimeout(() => $('#modalError').click(), 300);
      }
  );
  }

  invoiceDetail() {
    $('#addDetail').trigger('click');    
  }

  closeModal() {
    $('.modal .close').click();
  }

  addPlateDetail() {
    let isNumero = this.utilService.esNumero(this.value);
    if (!isNumero) {
      this.utilService.showErrors(this.toastrService, "Debes ingresar un número válido", "Importe");
      return ;

    }
    this.invoiceDetailDto = new InvoiceDetailDto();
    this.invoiceDetailDto.idChef = Number(this.chef);
    this.invoiceDetailDto.plate = this.plate;
    this.invoiceDetailDto.value = this.value;
    this.invoiceDetailDtoList.push(this.invoiceDetailDto);
    this.dataSource.data = this.invoiceDetailDtoList;
    this.valueTotal= Number(this.valueTotal) + Number(this.value);
    this.plate = '';
    this.value = 0;
    this.ngAfterViewInit();
    
  }

  saveInvoice() {
    
    this.invoiceDto = new InvoiceDto();
    this.invoiceDto.idClient = Number(this.client);
    this.invoiceDto.idWaiter = Number(this.waiter);
    this.invoiceDto.idTable = Number(this.tableRest);
    this.invoiceDto.invoiceDetailDtos = this.invoiceDetailDtoList;

    this.servicesService.addInvoicee(this.invoiceDto).subscribe((val: any) => {
        console.log('VAL -> ', val);
        this.ngOnInit();
        this.utilService.showSuccess(this.toastrService, "Se guardo satisfactoriamente", "Info");
       

    },
    (err: HttpErrorResponse) => {
            //setTimeout(() => this.spinner.hide(), 300);
            this.utilService.captureError(err);
            this.errorResponse = this.utilService.resetErrorResponse(err);
            setTimeout(() => $('#modalError').click(), 300);
        }
    );
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    
  }

}
