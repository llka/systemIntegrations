import {Component, DoCheck, OnChanges, OnInit} from '@angular/core';
import {DataService} from '../data.service';
import {MatrixCell} from '../matrix-cell/MatrixCell';
import {MatrixRow} from './MatrixRow';

@Component({
  selector: 'app-matrix',
  templateUrl: './matrix.component.html',
  styleUrls: ['./matrix.component.css']
})
export class MatrixComponent implements OnInit, DoCheck {

  matrix: MatrixCell[][];
  size: number;
  cellWidth: string;
  rows: MatrixRow[] = [];
  checkedOnce = true;

  constructor(private dataService: DataService) {
  }

  ngOnInit(): void {
    this.getMatrix();
  }

  ngDoCheck(): void {
    if (this.checkedOnce) {
      this.getMatrix();
      this.checkedOnce = false;
    }
  }


  getMatrix() {
    this.dataService.getMatrix().then(response => this.matrix = response);

    this.size = this.matrix[0].length;

    this.cellWidth = 100 / this.size + '%';

    for (let i = 0; i < this.size; i++) {
      this.rows[i] = new MatrixRow(this.matrix[i]);
    }
  }

}
