import { Component, OnInit, ViewChild } from '@angular/core';
import { ServicesService } from 'src/app/service/http/services.service';
import { UtilService } from 'src/app/service/http/util.service';
import { ErrorResponse } from 'src/app/model/errorResponse.model';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { TableRestDto } from 'src/app/model/table/tableRest.model';
import { HttpErrorResponse } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';

declare var jQuery: any;
declare var $: any;

@Component({
  selector: 'app-table-restaurant',
  templateUrl: './table-restaurant.component.html',
  styleUrls: ['./table-restaurant.component.css']
})
export class TableRestaurantComponent implements OnInit {

  displayedColumns: string[] = ['MaxComensaNumber', 'Location'];
  dataSource = new MatTableDataSource([]);
  //dataSource = new MatTableDataSource(ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  
  
  tableRestDtoList: TableRestDto[];
  tableRestDto: TableRestDto = new TableRestDto();
  
  errorResponse: ErrorResponse;

  constructor(private utilService: UtilService,
              private toastrService: ToastrService,
              private servicesService: ServicesService) { }

  ngOnInit() {
    this.tableRestDto.maxComensaNumber = 0;
    this.tableRestDto.location = '';
    this.dataSource.paginator = this.paginator;
    this.getTableList();
  }

  getTableList() {
        this.servicesService.getTables().subscribe((val: TableRestDto[]) => {
          console.log('VAL -> ', val);
          this.tableRestDtoList = val;
          if (this.tableRestDtoList !== null) {
            console.log('this.chefDtoList -> ', this.tableRestDtoList);
            this.dataSource.data = this.tableRestDtoList;
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

  addTable() {
    this.tableRestDto = new TableRestDto();
    
      $('#addTable').trigger('click');    
  }

  acceptSaveTable() {
        let isNumero = this.utilService.esNumero(this.tableRestDto.maxComensaNumber);
        if (!isNumero) {
          this.utilService.showErrors(this.toastrService, "Debes ingresar un número válido", "Num. Max Comensa");
          return ;

        }
        this.servicesService.addTable(this.tableRestDto).subscribe((val: any) => {
          console.log('VAL -> ', val);
          
          this.closeModal();
          this.getTableList();
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
