import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { InventoryComponent } from './inventory/inventory.component';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },

  { path: 'home', component: HomeComponent },
  { path: 'inventory', component: InventoryComponent },

  /*{ path: '**', component: PageNotFoundComponent },*/
];
