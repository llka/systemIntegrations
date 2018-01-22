import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {

  @Input() header: string;
  @Input() links: Map<string, string>;
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
