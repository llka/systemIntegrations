import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {MatrixCell} from './matrix-cell/MatrixCell';

@Injectable()
export class DataService {
  private matrixUrl = '/matrix';
  private systemsUrl = '/systems';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private httpClient: HttpClient) {
  }

  private handleError(error: any): Promise<any> {
    console.error('Error', error);
    return Promise.reject(error.message || error);
  }

  /* matrix */

  public getMatrix(): Promise<MatrixCell[][]> {
    return this.httpClient
      .get(this.matrixUrl, {headers: this.headers})
      .toPromise()
      .then(response => response as MatrixCell[][])
      .catch(this.handleError);
  }

}
