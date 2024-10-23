import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearComponent } from './funciones/crear/crear.component';
import { VerComponent } from './funciones/ver/ver.component';
import { ActualizarComponent } from './funciones/actualizar/actualizar.component';
import { EliminarComponent } from './funciones/eliminar/eliminar.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'crear',
  },
  {
    path: 'crear',
    component: CrearComponent,
  },
  {
    path: 'ver',
    component: VerComponent,
  },
  {
    path: 'actualizar',
    component: ActualizarComponent,
  },
  {
    path: 'eliminar',
    component: EliminarComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
