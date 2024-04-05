export class Item {
  id: number | null;
  brand: string;
  name: string;
  description: string;

  constructor(item: Partial<Item> = {}) {
    this.id = item?.id || null;
    this.brand = item?.brand || '';
    this.name = item?.name || '';
    this.description = item?.description || '';
  }
}
