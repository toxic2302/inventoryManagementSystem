import { Component, OnInit } from '@angular/core';
import { Ripple } from 'primeng/ripple';
import { Menubar } from 'primeng/menubar';
import { Badge } from 'primeng/badge';
import { Avatar } from 'primeng/avatar';
import { NgClass, NgIf } from '@angular/common';
import { MenuItem } from 'primeng/api';
import { InputText } from 'primeng/inputtext';
import { RouterLink } from '@angular/router';
import { Image } from 'primeng/image';

@Component({
  selector: 'ims-navbar',
  imports: [
    Ripple,
    Menubar,
    Badge,
    Avatar,
    NgClass,
    NgIf,
    InputText,
    RouterLink,
    Image
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent implements OnInit {
  items: MenuItem[] | undefined;

  ngOnInit() {
    this.items = [
      {
        label: 'Home',
        icon: 'pi pi-home',
        route: '/'
      },
      {
        label: 'Inventory',
        icon: 'pi pi-item',
        route: '/inventory'
      },
    ];
  }
}
