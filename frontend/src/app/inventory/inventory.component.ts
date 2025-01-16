import {Component, OnDestroy, OnInit} from '@angular/core';
import { TableModule } from 'primeng/table';
import { Button } from 'primeng/button';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../core/services/api.service';
import { AsyncPipe, JsonPipe } from '@angular/common';
import { Item } from '../core/models/Item';
import { Observable } from 'rxjs';
import {DialogService, DynamicDialogRef} from 'primeng/dynamicdialog';
import {MessageService} from 'primeng/api';
import {Toast} from 'primeng/toast';
import {EditItemComponent} from './edit-item/edit-item.component';
import {DialogFooterComponent} from '../core/components/dialog-footer/dialog-footer.component';

@Component({
  selector: 'ims-inventory',
  imports: [
    TableModule,
    Button,
    FormsModule,
    AsyncPipe,
    JsonPipe,
    Toast
  ],
  templateUrl: './inventory.component.html',
  styleUrl: './inventory.component.scss',
  providers: [DialogService, MessageService]
})
export class InventoryComponent implements OnInit, OnDestroy {
  items$!: Observable<Item[]>;

  ref: DynamicDialogRef | undefined;

  constructor(private apiService: ApiService, public dialogService: DialogService, public messageService: MessageService) {}

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

  show() {
    this.ref = this.dialogService.open(EditItemComponent, {
      header: 'Add inventory item',
      width: '50vw',
      modal: true,
      contentStyle: { overflow: 'auto' },
      breakpoints: {
        '960px': '75vw',
        '640px': '90vw'
      },
      templates: {
        footer: DialogFooterComponent
      }
    });

    this.ref.onClose.subscribe((data: any) => {
      let summary_and_detail;
      if (data) {
        const buttonType = data?.buttonType;
        summary_and_detail = buttonType ? { summary: 'No item added', detail: `Pressed '${buttonType}' button` } : { summary: 'Item added', detail: data?.name };
      } else {
        summary_and_detail = { summary: 'No item added', detail: 'Pressed Close button' };
      }
      this.messageService.add({ severity: 'info', ...summary_and_detail, life: 3000 });
    });

    this.ref.onMaximize.subscribe((value) => {
      this.messageService.add({ severity: 'info', summary: 'Maximized', detail: `maximized: ${value.maximized}` });
    });
  }

  ngOnDestroy() {
    if (this.ref) {
      this.ref.close();
    }
  }
}
