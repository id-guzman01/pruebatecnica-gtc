import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { grado } from '../interface/grado.interface';
import { environment } from '../../../environments/environment';
import { tipodocumento } from '../interface/tipo-documento.interface';
import { FormGroup } from '@angular/forms';
import { response } from '../interface/response.interface';
import { Estudiante } from '../interface/estudiante.interface';

@Injectable({
  providedIn: 'root',
})
export class FuncionesService {
  constructor(private http: HttpClient) {}

  findGrados(): Observable<grado> {
    return this.http.get<grado>(`${environment.apiUrl}/grado`);
  }

  findTipoDocumento(): Observable<tipodocumento> {
    return this.http.get<tipodocumento>(`${environment.apiUrl}/tipoDocumento`);
  }

  createEstudiante(data: FormGroup): Observable<response> {
    return this.http.post<response>(`${environment.apiUrl}/estudiantes`, data);
  }

  findEstudiantes(): Observable<Estudiante> {
    return this.http.get<Estudiante>(`${environment.apiUrl}/estudiantes`);
  }

  updateEstudiante(
    estudianteId: number,
    data: FormGroup
  ): Observable<response> {
    return this.http.put<response>(
      `${environment.apiUrl}/estudiantes/${estudianteId}`,
      data
    );
  }

  deleteEstudiante(estudianteId: number): Observable<response> {
    return this.http.delete<response>(
      `${environment.apiUrl}/estudiantes/${estudianteId}`
    );
  }
}
