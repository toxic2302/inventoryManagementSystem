import {Component, OnInit} from '@angular/core';
import { Ripple } from 'primeng/ripple';
import {Menubar} from 'primeng/menubar';
import {MenuItem, PrimeTemplate} from 'primeng/api';
import {RouterLink, RouterLinkActive} from '@angular/router';
import {AsyncPipe, NgIf, NgOptimizedImage} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {Avatar} from 'primeng/avatar';
import {Button} from 'primeng/button';
import {AuthService} from '@auth0/auth0-angular';

@Component({
  selector: 'ims-navbar',
  imports: [
    Ripple,
    Menubar,
    PrimeTemplate,
    RouterLink,
    NgOptimizedImage,
    RouterLinkActive,
    FormsModule,
    NgIf,
    Avatar,
    Button,
    AsyncPipe
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent implements OnInit {
  items: MenuItem[] | undefined;

  constructor(public auth: AuthService) { }

  ngOnInit() {
    this.items = [
      {
        label: 'Home',
        icon: 'pi pi-home',
        routerLink: '/home'
      },
      {
        label: 'Inventory',
        icon: 'pi pi-warehouse',
        routerLink: '/inventory'
      }
    ];
  }
}
