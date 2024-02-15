export class Item {
  id: number | null;
  name: string;
  description: string;

  constructor(item: Partial<Item> = {}) {
    this.id = item?.id || null;
    this.name = item?.name || '';
    this.description = item?.description || '';
  }
}
