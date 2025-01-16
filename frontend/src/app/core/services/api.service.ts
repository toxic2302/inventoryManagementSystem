import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Item} from '../models/Item';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  createInventoryItem(entry: Item): Observable<Item> {
    return this.http.post<Item>(`${environment.api.serverUrl}/api/item`, entry);
  }

  updateInventoryItem(id: string, updateEntry: Item): Observable<Item> {
    return this.http.post<Item>(`${environment.api.serverUrl}/api/items/${id}`, updateEntry)
  }

  deleteInventoryItem(uuid: string) {
    return this.http.delete(`${environment.api.serverUrl}/api/items/${uuid}`);
  }

  getInventoryItemById(id: string | null): Observable<Item> {
    return this.http.get<Item>(`${environment.api.serverUrl}/api/items/${id}`);
  }

  getInventoryItems(): Observable<Item[]> {
    return this.http.get<Item[]>(`${environment.api.serverUrl}/api/items`);
  }

  /*getCoffeeList(page?: number, size?: number): Observable<Page> {
    //TODO 19.12.24 floriankolb: eventuell schöner machen
    if (page !== undefined || size !== undefined) {
      return this.http.get<Page>(`${environment.api.serverUrl}/api/items`, {
        params: { page: page!, size: size! }
      });
    } else {
      return this.http.get<Page>(`${environment.api.serverUrl}/api/items`, {
        params: { size: 2 }
      });
    }
  }*/
}
