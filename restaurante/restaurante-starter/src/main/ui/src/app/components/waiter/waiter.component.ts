import { Component, OnInit, ViewChild } from '@angular/core';
import { UtilService } from 'src/app/service/http/util.service';
import { ServicesService } from 'src/app/service/http/services.service';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { WaiterDto } from 'src/app/model/waiter/waiterDto.model';
import { ErrorResponse } from 'src/app/model/errorResponse.model';
import { HttpErrorResponse } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';

declare var jQuery: any;
declare var $: any;

@Component({
  selector: 'app-waiter',
  templateUrl: './waiter.component.html',
  styleUrls: ['./waiter.component.css']
})
export class WaiterComponent implements OnInit {

  displayedColumns: string[] = ['Name', 'LastName1', 'LastName2'];
  dataSource = new MatTableDataSource([]);
  //dataSource = new MatTableDataSource(ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  
  name: string;
  lastName1: string;
  lastName2: string;
  comment: string;
  waiterDtoList: WaiterDto[];
  waiterDto: WaiterDto = new WaiterDto();
  
  errorResponse: ErrorResponse;

  constructor(private utilService: UtilService,
              private toastrService: ToastrService,
              private servicesService: ServicesService) { }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.getWaiterList();
  }

  getWaiterList() {
        this.servicesService.getWaiters().subscribe((val: WaiterDto[]) => {
          console.log('VAL -> ', val);
          this.waiterDtoList = val;
          if (this.waiterDtoList !== null) {
              console.log('this.waiterDtoList -> ', this.waiterDtoList);
              this.dataSource.data = this.waiterDtoList;
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

  addWaiter() {
    this.waiterDto = new WaiterDto();
      $('#addWaiter').trigger('click');    
  }

  acceptSaveWaiter() {
        this.servicesService.addWaiter(this.waiterDto).subscribe((val: any) => {
          console.log('VAL -> ', val);
          
          this.closeModal();
          this.getWaiterList();
          this.utilService.showSuccess(this.toastrService, "Se guardo satisfactoriamente", "Info");
      },
      (err: HttpErrorResponse) => {          
              this.utilService.captureError(err);
              this.errorResponse = this.utilService.resetErrorResponse(err);
              this.utilService.showErrors(this.toastrService, this.errorResponse.message, "Error!!!");
          }
      );

  }

}
