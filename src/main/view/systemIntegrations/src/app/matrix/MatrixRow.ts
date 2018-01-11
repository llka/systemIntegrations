import {MatrixCell} from '../matrix-cell/MatrixCell';

export class MatrixRow {
  private _row: MatrixCell[];

  constructor(row: MatrixCell[]) {
    this._row = row;
  }

  get row(): MatrixCell[] {
    return this._row;
  }

  set row(value: MatrixCell[]) {
    this._row = value;
  }
}
