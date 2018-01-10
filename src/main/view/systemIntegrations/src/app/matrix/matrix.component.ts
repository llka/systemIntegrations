import {Component, OnInit} from '@angular/core';
import {DataService} from '../data.service';
import {MatrixCell} from '../matrix-cell/MatrixCell';
import {MatrixRaw} from './MatrixRaw';

@Component({
  selector: 'app-matrix',
  templateUrl: './matrix.component.html',
  styleUrls: ['./matrix.component.css']
})
export class MatrixComponent implements OnInit {

  matrix: MatrixCell[][];
  size: number;
  cellWidth: string;
  raws: MatrixRaw[] = [];

  constructor(private dataService: DataService) {
  }

  ngOnInit() {
    this.getMatrix();
  }

  getMatrix() {
    this.dataService.getMatrix().then(response => this.matrix = response);

    this.size = this.matrix[0].length;

    this.cellWidth = 100 / this.size + '%';

    for (let i = 0; i < this.size; i++) {
      this.raws[i] = new MatrixRaw(this.matrix[i]);
    }
  }

}
