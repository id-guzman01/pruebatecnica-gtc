import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { tipodocumento } from '../interface/tipo-documento.interface';
import { grado } from '../interface/grado.interface';
import { FuncionesService } from '../service/funciones.service';
import { response } from '../interface/response.interface';

@Component({
  selector: 'app-crear',
  templateUrl: './crear.component.html',
  styleUrl: './crear.component.css',
})
export class CrearComponent implements OnInit {
  createEstudianteForm = this.fb.group({
    estudianteId: [0],
    tipodocumentoId: [0, [Validators.required, Validators.min(1)]],
    estudianteNumerodoc: [
      '',
      [Validators.required, Validators.pattern(/^[0-9]*$/)],
    ],
    estudianteNombres: ['', [Validators.required, Validators.minLength(3)]],
    estudianteApellidos: ['', [Validators.required, Validators.minLength(3)]],
    estudianteEdad: [
      '',
      [Validators.required, Validators.min(1), Validators.max(120)],
    ],
    estudianteCelular: [
      '',
      [Validators.required, Validators.pattern(/^[0-9]*$/)],
    ],
    estudianteTelefono: ['', [Validators.pattern(/^[0-9]*$/)]],
    estudianteEmail: ['', [Validators.required, Validators.email]],
    gradoId: [0, [Validators.required, Validators.min(1)]],
  });

  get getEstudianteId(): FormControl {
    return this.createEstudianteForm.get('estudianteId') as FormControl;
  }

  get getTipodocumentoId(): FormControl {
    return this.createEstudianteForm.get('tipodocumentoId') as FormControl;
  }

  get getEstudianteNumerodoc(): FormControl {
    return this.createEstudianteForm.get('estudianteNumerodoc') as FormControl;
  }

  get getEstudianteNombres(): FormControl {
    return this.createEstudianteForm.get('estudianteNombres') as FormControl;
  }

  get getEstudianteApellidos(): FormControl {
    return this.createEstudianteForm.get('estudianteApellidos') as FormControl;
  }

  get getEstudianteEdad(): FormControl {
    return this.createEstudianteForm.get('estudianteEdad') as FormControl;
  }

  get getEstudianteCelular(): FormControl {
    return this.createEstudianteForm.get('estudianteCelular') as FormControl;
  }

  get getEstudianteTelefono(): FormControl {
    return this.createEstudianteForm.get('estudianteTelefono') as FormControl;
  }

  get getEstudianteEmail(): FormControl {
    return this.createEstudianteForm.get('estudianteEmail') as FormControl;
  }

  get getGradoId(): FormControl {
    return this.createEstudianteForm.get('gradoId') as FormControl;
  }

  constructor(
    private fb: FormBuilder,
    private funcionesService: FuncionesService
  ) {}

  listTipoDocumento: tipodocumento[] = [];
  listGrado: grado[] = [];

  ngOnInit(): void {
    this.funcionesService.findGrados().subscribe((data: grado) => {
      this.listGrado = this.listGrado.concat(data);
    });
    this.funcionesService
      .findTipoDocumento()
      .subscribe((data: tipodocumento) => {
        this.listTipoDocumento = this.listTipoDocumento.concat(data);
      });
  }

  createEstudiante(): void {
    const data = this.createEstudianteForm.value as FormGroup;
    this.funcionesService.createEstudiante(data).subscribe(
      (data: response) => {
        alert('Estudiante creado con exito');
      },
      (error) => {
        alert('Fallo la creacion del estudiante');
      }
    );
    this.canelar();
  }

  canelar(): void {
    this.createEstudianteForm.reset({
      estudianteId: 0,
      tipodocumentoId: 0,
      estudianteNumerodoc: '',
      estudianteNombres: '',
      estudianteApellidos: '',
      estudianteEdad: '',
      estudianteCelular: '',
      estudianteTelefono: '',
      estudianteEmail: '',
      gradoId: 0,
    });
  }
}
