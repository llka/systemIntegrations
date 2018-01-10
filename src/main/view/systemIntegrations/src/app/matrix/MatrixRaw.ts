import {MatrixCell} from '../matrix-cell/MatrixCell';

export class MatrixRaw {
  private _raw: MatrixCell[];

  constructor(raw: MatrixCell[]) {
    this._raw = raw;
  }

  get raw(): MatrixCell[] {
    return this._raw;
  }

  set raw(value: MatrixCell[]) {
    this._raw = value;
  }
}
