import {Component, Input, OnInit} from '@angular/core';
import {MatrixCell} from './MatrixCell';
import {SystemMatrixCell} from './SystemMatrixCell';
import {IntegrationMatrixCell} from './IntegrationMatrixCell';

@Component({
  selector: 'app-matrix-cell',
  templateUrl: './matrix-cell.component.html',
  styleUrls: ['./matrix-cell.component.css']
})
export class MatrixCellComponent implements OnInit {

  @Input() matrixCell: MatrixCell;
  cellType: string;

  constructor() {
  }

  ngOnInit() {

    const systemCell: SystemMatrixCell = <SystemMatrixCell>this.matrixCell;
    const integrationCell: IntegrationMatrixCell = <IntegrationMatrixCell>this.matrixCell;

    this.cellType = 'cell';

    if (typeof systemCell.system !== 'undefined') {
      this.matrixCell = systemCell;
      this.cellType = 'system';
    }
    if (typeof integrationCell.integration !== 'undefined') {
      this.matrixCell = integrationCell;
      this.cellType = 'integration';
    }
  }
}
