import {Component, OnInit} from '@angular/core';
import {InputText} from 'primeng/inputtext';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {ApiService} from '../../core/services/api.service';
import {Router} from '@angular/router';
import {ButtonDirective} from 'primeng/button';
import {Ripple} from 'primeng/ripple';

@Component({
  selector: 'ims-edit-item',
  imports: [
    InputText,
    ButtonDirective,
    Ripple,
    ReactiveFormsModule
  ],
  templateUrl: './edit-item.component.html',
  styleUrl: './edit-item.component.scss'
})
export class EditItemComponent implements OnInit {
  form!: FormGroup;

  constructor(private fb: FormBuilder, private apiService: ApiService, private router: Router) {
  }

  ngOnInit() {
    this.form = this.fb.group({
      brand: ['', Validators.required],
      name: ['', Validators.required],
      amount: ['', Validators.required]
    });
  }

  onSubmit() {
    this.apiService.createInventoryItem(this.form.value).subscribe(res => {
      /*this.messages = [{ severity: 'success', detail: 'Entry added' }];*/
      this.router.navigateByUrl('/inventory').then(r => console.log(r));
    }, error => {
      /*this.messages = [{ severity: 'error', detail: error }];*/
    });
  }
}
