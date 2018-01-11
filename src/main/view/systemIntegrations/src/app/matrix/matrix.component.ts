import {Component, OnInit} from '@angular/core';
import {DataService} from '../data.service';
import {MatrixCell} from '../matrix-cell/MatrixCell';
import {MatrixRow} from './MatrixRow';

@Component({
  selector: 'app-matrix',
  templateUrl: './matrix.component.html',
  styleUrls: ['./matrix.component.css']
})
export class MatrixComponent implements OnInit {

  matrix: MatrixCell[][];
  size: number;
  cellWidth: string;
  rows: MatrixRow[] = [];

  constructor(private dataService: DataService) {
  }

  ngOnInit(): void {
    this.getMatrix();
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
