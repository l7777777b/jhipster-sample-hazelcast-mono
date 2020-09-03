import { Moment } from 'moment';
import { IProduct } from 'app/shared/model/product.model';
import { CategoryStatus } from 'app/shared/model/enumerations/category-status.model';

export interface ICategory {
  id?: number;
  description?: string;
  sortOrder?: number;
  dateAdded?: Moment;
  dateModified?: Moment;
  status?: CategoryStatus;
  parentId?: number;
  products?: IProduct[];
}

export class Category implements ICategory {
  constructor(
    public id?: number,
    public description?: string,
    public sortOrder?: number,
    public dateAdded?: Moment,
    public dateModified?: Moment,
    public status?: CategoryStatus,
    public parentId?: number,
    public products?: IProduct[]
  ) {}
}
