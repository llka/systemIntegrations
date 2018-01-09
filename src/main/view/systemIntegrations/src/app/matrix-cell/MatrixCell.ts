import {Coordinates} from './Coordinates';

export class MatrixCell {
  private _coordinates: Coordinates;
  private _displayedInfo: string;

  constructor(x: number, y: number, displayedInfo: string) {
    this._coordinates = new Coordinates(x, y);
    this._displayedInfo = displayedInfo;
  }

  get coordinates(): Coordinates {
    return this._coordinates;
  }

  set coordinates(value: Coordinates) {
    this._coordinates = value;
  }

  get displayedInfo(): string {
    return this._displayedInfo;
  }

  set displayedInfo(value: string) {
    this._displayedInfo = value;
  }
}
