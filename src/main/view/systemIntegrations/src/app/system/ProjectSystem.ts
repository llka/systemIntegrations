import {Integration} from '../integration/Integration';

export class ProjectSystem {
  private _fullName: string;
  private _systemId: string;
  private _links: Map<string, string>;
  private _integrationsFrom: Integration[];
  private _integrationsReceived: Integration[];


  constructor(fullName: string, systemId: string, links: Map<string, string>, integrationsFrom: Integration[], integrationsReceived: Integration[]) {
    this._fullName = fullName;
    this._systemId = systemId;
    this._links = links;
    this._integrationsFrom = integrationsFrom;
    this._integrationsReceived = integrationsReceived;
  }


  get fullName(): string {
    return this._fullName;
  }

  set fullName(value: string) {
    this._fullName = value;
  }

  get systemId(): string {
    return this._systemId;
  }

  set systemId(value: string) {
    this._systemId = value;
  }

  get links(): Map<string, string> {
    return this._links;
  }

  set links(value: Map<string, string>) {
    this._links = value;
  }

  get integrationsFrom(): Integration[] {
    return this._integrationsFrom;
  }

  set integrationsFrom(value: Integration[]) {
    this._integrationsFrom = value;
  }

  get integrationsReceived(): Integration[] {
    return this._integrationsReceived;
  }

  set integrationsReceived(value: Integration[]) {
    this._integrationsReceived = value;
  }
}
