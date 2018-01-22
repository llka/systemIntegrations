import {Injectable} from '@angular/core';
import {ModalComponent} from './modal/modal.component';

@Injectable()
export class ModalService {

  constructor() {
  }

  public openModal(modal: ModalComponent) {
    modal.openModal();
  }

  public closeModal(modal: ModalComponent){
    modal.closeModal();
  }
}
