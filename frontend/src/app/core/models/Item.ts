import {User} from './User';

export interface Item {
  id: number;
  name: string;
  brand: string;
  serialNumber: string;
  description: string;
  user: User;
  sold: boolean;
  amount: number;
}
