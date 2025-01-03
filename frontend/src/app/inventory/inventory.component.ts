import { Component, OnInit } from '@angular/core';
import { TableModule } from 'primeng/table';
import { Button } from 'primeng/button';
import { Rating } from 'primeng/rating';
import { Tag } from 'primeng/tag';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../core/services/api.service';
import { Product } from '../core/models/Product';
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'ims-inventory',
  imports: [
    TableModule,
    Button,
    Rating,
    Tag,
    FormsModule,
    CurrencyPipe
  ],
  templateUrl: './inventory.component.html',
  styleUrl: './inventory.component.scss'
})
export class InventoryComponent implements OnInit {
  products!: Product[];

  constructor(private apiService: ApiService) {}

  ngOnInit() {
   this.apiService.getProductsMini().then((products: Product[]) => {
     this.products = products;
   });
  }

  // @ts-ignore
  getSeverity(status: string) {
    switch (status) {
      case 'INSTOCK':
        return 'success';
      case 'LOWSTOCK':
        return 'warn';
      case 'OUTOFSTOCK':
        return 'danger';
    }
  }
}
