import { Component, OnInit, ViewChild } from '@angular/core';
import { UtilService } from 'src/app/service/http/util.service';
import { ServicesService } from 'src/app/service/http/services.service';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { ReportWaiterDto } from 'src/app/model/report/reportWaiterDto.model';
import { HttpErrorResponse } from '@angular/common/http';
import { ErrorResponse } from 'src/app/model/errorResponse.model';
import { ReportClientDto } from 'src/app/model/report/reportClientDto.model';

declare var jQuery: any;
declare var $: any;

@Component({
  selector: 'app-report-restaurant',
  templateUrl: './report-restaurant.component.html',
  styleUrls: ['./report-restaurant.component.css']
})
export class ReportRestaurantComponent implements OnInit {

  reportGeneral: string;
  reportWaiterDtoList: ReportWaiterDto[] = [];
  reportClientDtoList: ReportClientDto[] = [];

  displayedColumns: string[] = ['Name', 'Date', 'Total'];
  displayedClienteColumns: string[] = ['Name'];
  dataSource = new MatTableDataSource([]);
  errorResponse: ErrorResponse;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private utilService: UtilService,
              private servicesService: ServicesService) { }

  ngOnInit() {
    this.reportGeneral = '';
  }

  getReport() {
      if (this.reportGeneral === "1") {
          this.getReportWaiterList();
      }else if (this.reportGeneral === "2") {
          this.getReportClientList();
      }
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    
  }

  updateReport() {
    
    this.dataSource.data = [];
    
  }

  getReportWaiterList() {
    this.servicesService.getReportWaiter().subscribe((val: ReportWaiterDto[]) => {
      console.log('VAL -> ', val);
      this.reportWaiterDtoList = val;
      if (this.reportWaiterDtoList !== null) {
        console.log('this.reportWaiterDtoList -> ', this.reportWaiterDtoList);
        this.dataSource.data = this.reportWaiterDtoList;
        this.ngAfterViewInit();
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

  getReportClientList() {
    this.servicesService.getReportClient().subscribe((val: ReportWaiterDto[]) => {
      console.log('VAL -> ', val);
      this.reportClientDtoList = val;
      if (this.reportClientDtoList !== null) {
        console.log('this.reportClientDtoList -> ', this.reportClientDtoList);
        this.dataSource.data = this.reportClientDtoList;
        this.ngAfterViewInit();
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

}
