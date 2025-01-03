import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor() { }

  getProductsMini() {
    return fetch('/assets/products.json').then(value => value.json());
  }
}
