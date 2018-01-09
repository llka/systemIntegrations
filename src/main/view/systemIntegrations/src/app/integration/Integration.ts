export class Integration {
  private _fromProjectSystemId: string;
  private _toProjectSystemId: string;
  private _integrationDocsUrl: string;

  constructor(fromProjectSystemId: string, toProjectSystemId: string, integrationDocsUrl: string) {
    this._fromProjectSystemId = fromProjectSystemId;
    this._toProjectSystemId = toProjectSystemId;
    this._integrationDocsUrl = integrationDocsUrl;
  }


  get fromProjectSystemId(): string {
    return this._fromProjectSystemId;
  }

  set fromProjectSystemId(value: string) {
    this._fromProjectSystemId = value;
  }

  get toProjectSystemId(): string {
    return this._toProjectSystemId;
  }

  set toProjectSystemId(value: string) {
    this._toProjectSystemId = value;
  }

  get integrationDocsUrl(): string {
    return this._integrationDocsUrl;
  }

  set integrationDocsUrl(value: string) {
    this._integrationDocsUrl = value;
  }
}
