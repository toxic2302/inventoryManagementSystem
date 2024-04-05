import { Component } from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {DatePipe} from "@angular/common";
import {MatIconModule} from "@angular/material/icon";
import {MatTableModule} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
import {RouterLink} from "@angular/router";
import {Item} from "../model/item";
import {AuthService} from "../services/auth.service";
import {User} from "../model/user";

@Component({
  selector: 'app-inventory',
  standalone: true,
  imports: [RouterLink, MatButtonModule, MatTableModule, MatIconModule, DatePipe, HttpClientModule],
  templateUrl: './inventory.component.html',
  styleUrl: './inventory.component.scss'
})
export class InventoryComponent {
  title = 'Inventory';
  loading = true;
  items: Item[] = [];
  displayedColumns = ['brand', 'name', 'description', 'actions'];
  feedback: any = {};
  user!: User;

  constructor(private http: HttpClient, public auth: AuthService) {}

  async ngOnInit() {
    this.loading = true;

    await this.auth.isAuthenticated();
    this.auth.getUser().subscribe(data => this.user = data);

    this.http.get<Item[]>('api/items').subscribe((data: Item[]) => {
      this.items = data;
      this.loading = false;
      this.feedback = {};
    });
  }

  delete(item: Item): void {
    if (confirm(`Are you sure you want to delete ${item.name}?`)) {
      this.http.delete(`api/item/${item.id}`).subscribe({
        next: () => {
          this.feedback = {type: 'success', message: 'Delete was successful!'};
          setTimeout(() => {
            this.ngOnInit();
          }, 1000);
        },
        error: () => {
          this.feedback = {type: 'warning', message: 'Error deleting.'};
        }
      });
    }
  }

  protected readonly event = event;
}
