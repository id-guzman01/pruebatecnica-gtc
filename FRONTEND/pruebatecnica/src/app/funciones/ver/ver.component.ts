import { Component, OnInit } from '@angular/core';
import { FuncionesService } from '../service/funciones.service';
import { Estudiante } from '../interface/estudiante.interface';
import { response } from '../interface/response.interface';

@Component({
  selector: 'app-ver',
  templateUrl: './ver.component.html',
  styleUrl: './ver.component.css',
})
export class VerComponent implements OnInit {
  listEstudiante: Estudiante[] = [];

  constructor(private funcionalidadesService: FuncionesService) {}

  ngOnInit(): void {
    this.cargarData();
  }

  cargarData(): void {
    this.funcionalidadesService
      .findEstudiantes()
      .subscribe((data: Estudiante) => {
        this.listEstudiante = [];
        this.listEstudiante = this.listEstudiante.concat(data);
      });
  }

  deleteEstudiante(estudianteId: number): void {
    this.funcionalidadesService.deleteEstudiante(estudianteId).subscribe(
      (data: response) => {
        alert('Estudiante eliminado');
        this.cargarData();
      },
      (error) => {
        alert('Error en el proceso de eliminiación');
      }
    );
  }
}
