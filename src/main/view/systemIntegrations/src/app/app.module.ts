import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { SystemComponent } from './system/system.component';
import { MatrixComponent } from './matrix/matrix.component';
import { MatrixCellComponent } from './matrix-cell/matrix-cell.component';
import { IntegrationComponent } from './integration/integration.component';
import {DataService} from './data.service';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    SystemComponent,
    MatrixComponent,
    MatrixCellComponent,
    IntegrationComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
