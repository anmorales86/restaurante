import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { ChefDto } from 'src/app/model/chef/chefDto.model';
import { ErrorResponse } from 'src/app/model/errorResponse.model';
import { HttpErrorResponse } from '@angular/common/http';
import { UtilService } from 'src/app/service/http/util.service';
import { ServicesService } from 'src/app/service/http/services.service';
import { ToastrService } from 'ngx-toastr';

declare var jQuery: any;
declare var $: any;

@Component({
  selector: 'app-chef',
  templateUrl: './chef.component.html',
  styleUrls: ['./chef.component.css']
})
export class ChefComponent implements OnInit {

  displayedColumns: string[] = ['Name', 'LastName1', 'LastName2'];
  dataSource = new MatTableDataSource([]);
  //dataSource = new MatTableDataSource(ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  
  name: string;
  lastName1: string;
  lastName2: string;
  comment: string;
  chefDtoList: ChefDto[];
  chefDto: ChefDto = new ChefDto();
  
  errorResponse: ErrorResponse;

  constructor(private utilService: UtilService,
              private toastrService: ToastrService,
              private servicesService: ServicesService) { }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.getChefList();

  }

  getChefList() {
        this.servicesService.getChefs().subscribe((val: ChefDto[]) => {
          console.log('VAL -> ', val);
          this.chefDtoList = val;
          if (this.chefDtoList !== null) {
            console.log('this.chefDtoList -> ', this.chefDtoList);
            this.dataSource.data = this.chefDtoList;
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

  addChef() {
    this.chefDto = new ChefDto();
      $('#addChef').trigger('click');    
  }

  acceptSaveChef() {
        this.servicesService.addChef(this.chefDto).subscribe((val: any) => {
          console.log('VAL -> ', val);
          
          this.closeModal();
          this.getChefList();
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
