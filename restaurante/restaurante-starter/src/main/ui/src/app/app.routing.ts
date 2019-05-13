import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './components/main/main.component';
import { ClientComponent } from './components/client/client.component';
import { InvoiceComponent } from './components/invoice/invoice.component';
import { ChefComponent } from './components/chef/chef.component';
import { WaiterComponent } from './components/waiter/waiter.component';
import { TableRestaurantComponent } from './components/table-restaurant/table-restaurant.component';
import { ReportRestaurantComponent } from './components/report-restaurant/report-restaurant.component';




const appRoutes: Routes = [
    { path: '', component: MainComponent },
    { path: 'client', component: ClientComponent },
    { path: 'chef', component: ChefComponent },
    { path: 'waiter', component: WaiterComponent },
    { path: 'tableRest', component: TableRestaurantComponent },
    { path: 'reportRest', component: ReportRestaurantComponent },
    { path: 'invoice', component: InvoiceComponent }
    
    //{ path: '', redirectTo: 'getLists', pathMatch: 'full' }
 ];

 export const routing = RouterModule.forRoot(appRoutes);
