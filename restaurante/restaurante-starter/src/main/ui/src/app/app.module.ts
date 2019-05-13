import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing } from './app.routing';
import { AppComponent } from './app.component';
import { MenuComponent } from './components/menu/menu.component';
import { HeaderComponent } from './components/header/header.component';
import { LoadingComponent } from './components/loading/loading.component';
import { FooterComponent } from './components/footer/footer.component';
import { MainComponent } from './components/main/main.component';
import { InvoiceComponent } from './components/invoice/invoice.component';
import { ClientComponent } from './components/client/client.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { CommonModule } from '@angular/common';
import { MatInputModule, MatTableModule, MatToolbarModule, MatPaginatorModule } from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BaseService } from './service/http/base.service';
import { ServicesService } from './service/http/services.service';
import { HttpClientModule } from '@angular/common/http';
import { UtilService } from './service/http/util.service';
import { ChefComponent } from './components/chef/chef.component';
import { WaiterComponent } from './components/waiter/waiter.component';
import { TableRestaurantComponent } from './components/table-restaurant/table-restaurant.component';
import { ReportRestaurantComponent } from './components/report-restaurant/report-restaurant.component';
import { ToastrModule } from 'ngx-toastr';


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HeaderComponent,
    LoadingComponent,
    FooterComponent,
    MainComponent,
    InvoiceComponent,
    ClientComponent,
    ChefComponent,
    WaiterComponent,
    TableRestaurantComponent,
    ReportRestaurantComponent
  ],
  imports: [
    
    BrowserModule,
    MatPaginatorModule,
    routing,
    MatInputModule, 
    MatTableModule, 
    MatToolbarModule,
    CommonModule,    
    BrowserAnimationsModule,
    FormsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [ServicesService, UtilService],
  bootstrap: [AppComponent]
})
export class AppModule { }
