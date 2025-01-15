import { Component } from '@angular/core';
import { ButtonDirective } from 'primeng/button';
import { Ripple } from 'primeng/ripple';
import {NgOptimizedImage} from '@angular/common';

@Component({
  selector: 'ims-home',
  imports: [
    ButtonDirective,
    Ripple,
    NgOptimizedImage
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
