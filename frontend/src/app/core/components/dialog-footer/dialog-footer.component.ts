import { Component } from '@angular/core';
import {Button} from 'primeng/button';
import {DynamicDialogRef} from 'primeng/dynamicdialog';

@Component({
  selector: 'ims-dialog-footer',
  imports: [
    Button
  ],
  templateUrl: './dialog-footer.component.html',
  styleUrl: './dialog-footer.component.scss'
})
export class DialogFooterComponent {

  constructor(public ref: DynamicDialogRef) {}

  closeDialog(data: any) {
    this.ref.close(data);
  }
}
