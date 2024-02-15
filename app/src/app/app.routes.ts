import { Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {InventoryComponent} from "./inventory/inventory.component";
import {ItemEditComponent} from "./item-edit/item-edit.component";

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'inventory',
    component: InventoryComponent
  },
  {
    path: 'item/:id',
    component: ItemEditComponent
  }
];
