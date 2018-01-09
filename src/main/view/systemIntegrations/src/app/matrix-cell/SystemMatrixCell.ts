import {MatrixCell} from './MatrixCell';
import {ProjectSystem} from '../system/ProjectSystem';

export class SystemMatrixCell extends MatrixCell {
  private _system: ProjectSystem;

  constructor(x: number, y: number, displayedInfo: string, system: ProjectSystem) {
    super(x, y, displayedInfo);
    this._system = system;
  }

  get system(): ProjectSystem {
    return this._system;
  }

  set system(value: ProjectSystem) {
    this._system = value;
  }
}
