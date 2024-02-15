import {Component, OnInit} from '@angular/core';
import {RouterLink} from "@angular/router";
import {AuthService} from "../services/auth.service";
import {User} from "../model/user";
import {MatButtonModule} from "@angular/material/button";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MatButtonModule, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {
  isAuthenticated!: boolean;
  user!: User;

  constructor(public auth: AuthService) {}

  async ngOnInit() {
    this.isAuthenticated = await this.auth.isAuthenticated();
    this.auth.getUser().subscribe(data => this.user = data);
  }
}
