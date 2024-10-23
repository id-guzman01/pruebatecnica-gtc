import { grado } from './grado.interface';
import { tipodocumento } from './tipo-documento.interface';

export interface Estudiante {
  estudianteId: number;
  tipodocumentoId: number;
  estudianteNumerodoc: number;
  estudianteNombres: string;
  estudianteApellidos: string;
  estudianteEdad: string;
  estudianteCelular: number;
  estudianteTelefono: number;
  estudianteEmail: string;
  gradoId: number;
  gradoDTO: grado;
  tipoDocumentoDTO: tipodocumento;
}
