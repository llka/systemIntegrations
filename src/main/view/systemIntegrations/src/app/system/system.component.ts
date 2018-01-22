import {Component, Input, OnInit} from '@angular/core';
import {SystemMatrixCell} from '../matrix-cell/SystemMatrixCell';

@Component({
  selector: 'app-system',
  templateUrl: './system.component.html',
  styleUrls: ['./system.component.css']
})
export class SystemComponent implements OnInit {

  @Input() systemCell: SystemMatrixCell;
  displayModal = 'none';
  linksMap: Map<string, string>;
  linksArray;

  constructor() {
  }

  ngOnInit() {
    this.linksMap = this.buildMap(this.systemCell.system.links);
    this.linksArray = Array.from(this.linksMap);
  }

  buildMap(obj) {
    return Object.keys(obj).reduce((map, key) => map.set(key, obj[key]), new Map());
  }

  logMapElements(value, key, map) {
    console.log(`${key} = ${value}`);
  }

  openModal() {
    this.displayModal = 'block';
  }

  closeModal() {
    this.displayModal = 'none';
  }

}
