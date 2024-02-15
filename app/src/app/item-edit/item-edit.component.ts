import {Component, OnInit} from '@angular/core';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {MatIconModule} from "@angular/material/icon";
import {FormsModule} from "@angular/forms";
import {MatNativeDateModule} from "@angular/material/core";
import {MatTooltipModule} from "@angular/material/tooltip";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {Item} from "../model/item";
import {map, of, switchMap} from "rxjs";

@Component({
  selector: 'app-item-edit',
  standalone: true,
  imports: [
    FormsModule,
    HttpClientModule,
    MatInputModule,
    MatButtonModule,
    MatDatepickerModule,
    MatIconModule,
    MatNativeDateModule,
    MatTooltipModule,
    RouterLink
  ],
  templateUrl: './item-edit.component.html',
  styleUrl: './item-edit.component.scss'
})
export class ItemEditComponent implements OnInit {
  item!: Item;
  feedback: any = {};

  constructor(private route: ActivatedRoute, private router: Router, private http: HttpClient) {}

  ngOnInit() {
    this.route.params.pipe(
      map(p => p['id']),
      switchMap(id => {
        if (id === 'new') {
          return of(new Item());
        }
        return this.http.get<Item>(`api/item/${id}`);
      })
    ).subscribe({
      next: item => {
        this.item = item;
        this.feedback = {};
      },
      error: () => {
        this.feedback = {type: 'warning', message: 'Error loading'};
      }
    });
  }

  save() {
    const id = this.item.id;
    const method = id ? 'put' : 'post';

    this.http[method](`/api/item${id ? '/' + id : ''}`, this.item).subscribe({
      next: () => {
        this.feedback = {type: 'success', message: 'Save was successful!'};
        setTimeout(async () => {
          await this.router.navigate(['/inventory']);
        }, 1000);
      },
      error: () => {
        this.feedback = {type: 'error', message: 'Error saving'};
      }
    });
  }

  async cancel() {
    await this.router.navigate(['/inventory']);
  }
}
