import { Component, OnInit } from '@angular/core';
import { TableModule } from 'primeng/table';
import { Button } from 'primeng/button';
import { Rating } from 'primeng/rating';
import { Tag } from 'primeng/tag';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../core/services/api.service';
import { AsyncPipe, CurrencyPipe, JsonPipe } from '@angular/common';
import { Item } from '../core/models/Item';
import { Observable } from 'rxjs';

@Component({
  selector: 'ims-inventory',
  imports: [
    TableModule,
    Button,
    FormsModule,
    AsyncPipe,
    JsonPipe
  ],
  templateUrl: './inventory.component.html',
  styleUrl: './inventory.component.scss'
})
export class InventoryComponent implements OnInit {
  items$!: Observable<Item[]>;

  constructor(private apiService: ApiService) {}

  ngOnInit() {
   this.items$ = this.apiService.getInventoryItems();
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
