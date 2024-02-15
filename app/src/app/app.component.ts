import {Component, OnInit} from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
import {MatButtonModule} from "@angular/material/button";
import {MatToolbar} from "@angular/material/toolbar";
import {MatMenuItem} from "@angular/material/menu";
import {User} from "./model/user";
import {AuthService} from "./services/auth.service";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [MatButtonModule, RouterOutlet, MatToolbar, RouterLink, MatMenuItem],
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
