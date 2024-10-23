import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { CrearComponent } from './funciones/crear/crear.component';
import { VerComponent } from './funciones/ver/ver.component';
import { ActualizarComponent } from './funciones/actualizar/actualizar.component';
import { EliminarComponent } from './funciones/eliminar/eliminar.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    CrearComponent,
    VerComponent,
    ActualizarComponent,
    EliminarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
