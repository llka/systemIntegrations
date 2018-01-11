import {Component, Input, OnInit} from '@angular/core';
import {IntegrationMatrixCell} from '../matrix-cell/IntegrationMatrixCell';

@Component({
  selector: 'app-integration',
  templateUrl: './integration.component.html',
  styleUrls: ['./integration.component.css']
})
export class IntegrationComponent implements OnInit {

  @Input() integrationCell: IntegrationMatrixCell;
  displayModal = 'none';

  constructor() {
  }

  ngOnInit() {
  }

  openModal() {
    this.displayModal = 'block';
  }

  closeModal() {
    this.displayModal = 'none';
  }

}
