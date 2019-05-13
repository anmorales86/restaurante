import { Component, OnInit, ViewChild } from '@angular/core';

import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { HttpErrorResponse } from '@angular/common/http';
import { UtilService } from 'src/app/service/http/util.service';
import { ServicesService } from 'src/app/service/http/services.service';
import { ErrorResponse } from 'src/app/model/errorResponse.model';
import { ClientDto } from 'src/app/model/client/clientDto.model';
import { ToastrService } from 'ngx-toastr';

declare var jQuery: any;
declare var $: any;

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  displayedColumns: string[] = ['Name', 'LastName1', 'LastName2', 'Comment'];
  dataSource = new MatTableDataSource([]);
  //dataSource = new MatTableDataSource(ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  
  name: string;
  lastName1: string;
  lastName2: string;
  comment: string;
  clientDtoList: ClientDto[];
  clientDto: ClientDto = new ClientDto();
  
  errorResponse: ErrorResponse;


  constructor(private utilService: UtilService,
              private toastrService: ToastrService,
              private servicesService: ServicesService) { }

  ngOnInit() {
    
    this.dataSource.paginator = this.paginator;
    this.getClientList();


  }

  getClientList() {
        this.servicesService.getClients().subscribe((val: ClientDto[]) => {
          console.log('VAL -> ', val);
          this.clientDtoList = val;
          if (this.clientDtoList !== null) {
              console.log('this.clientDto -> ', this.clientDtoList);
              this.dataSource.data = this.clientDtoList;
          }
          
          
          
      },
      (err: HttpErrorResponse) => {
              this.utilService.captureError(err);
              this.errorResponse = this.utilService.resetErrorResponse(err);
              this.utilService.showErrors(this.toastrService, this.errorResponse.message, "Error!!!");
          }
      );
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    
  }
  
  


  closeModal() {
    $('.modal .close').click();
  }

  addClient() {
    this.clientDto = new ClientDto();
      $('#addClient').trigger('click');    
  }

  acceptSaveClient() {
        this.servicesService.addClient(this.clientDto).subscribe((val: any) => {
          console.log('VAL -> ', val);
          
          this.closeModal();
          this.utilService.showSuccess(this.toastrService, "Se guardo satisfactoriamente", "Info");
          this.getClientList();
          
          

      },
      (err: HttpErrorResponse) => {
              this.utilService.captureError(err);
              this.errorResponse = this.utilService.resetErrorResponse(err);
              this.utilService.showErrors(this.toastrService, this.errorResponse.message, "Error!!!");
          }
      );

  }

}

