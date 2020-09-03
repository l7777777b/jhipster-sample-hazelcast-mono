import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IWishList } from 'app/shared/model/wish-list.model';

type EntityResponseType = HttpResponse<IWishList>;
type EntityArrayResponseType = HttpResponse<IWishList[]>;

@Injectable({ providedIn: 'root' })
export class WishListService {
  public resourceUrl = SERVER_API_URL + 'api/wish-lists';

  constructor(protected http: HttpClient) {}

  create(wishList: IWishList): Observable<EntityResponseType> {
    return this.http.post<IWishList>(this.resourceUrl, wishList, { observe: 'response' });
  }

  update(wishList: IWishList): Observable<EntityResponseType> {
    return this.http.put<IWishList>(this.resourceUrl, wishList, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IWishList>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IWishList[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
