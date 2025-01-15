import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  /*getInventory(entry: CoffeeListEntry): Observable<CoffeeListEntry> {
    return this.http.post<CoffeeListEntry>(`${environment.api.serverUrl}/api/inventory`, entry);
  }*/

  getProductsMini() {
    return fetch('/assets/products.json').then(value => value.json());
  }
}
