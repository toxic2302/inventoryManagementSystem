import {Component, OnInit} from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
import {MatButtonModule} from "@angular/material/button";
import {MatToolbar} from "@angular/material/toolbar";
import {MatMenu, MatMenuItem, MatMenuTrigger} from "@angular/material/menu";
import {User} from "./model/user";
import {AuthService} from "./services/auth.service";
import {MatIcon} from "@angular/material/icon";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [MatButtonModule, RouterOutlet, MatToolbar, RouterLink, MatMenuItem, MatMenu, MatMenuTrigger, MatIcon],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'IMS';
  isAuthenticated!: boolean;
  user!: User;

  constructor(public auth: AuthService) {}

  async ngOnInit() {
    this.isAuthenticated = await this.auth.isAuthenticated();
    this.auth.getUser().subscribe(data => this.user = data);
  }
}
