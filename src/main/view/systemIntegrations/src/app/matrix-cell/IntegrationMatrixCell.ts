import {MatrixCell} from './MatrixCell';
import {Integration} from '../integration/Integration';

export class IntegrationMatrixCell extends MatrixCell {
  private _integration: Integration;

  constructor(x: number, y: number, displayedInfo: string, integration: Integration) {
    super(x, y, displayedInfo);
    this._integration = integration;
  }

  get integration(): Integration {
    return this._integration;
  }

  set integration(value: Integration) {
    this._integration = value;
  }
}
