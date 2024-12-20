import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { VoitureService } from '../../services/voiture.service';
import { ClientService } from '../../services/client.service';
import { Client } from '../../models/client';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-add-voiture',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './add-voiture.component.html'
})
export class AddVoitureComponent implements OnInit {
  voitureForm: FormGroup;
  clients: Client[] = [];

  constructor(
    private fb: FormBuilder,
    private voitureService: VoitureService,
    private clientService: ClientService,
    private router: Router
  ) {
    this.voitureForm = this.fb.group({
      matricule: ['', Validators.required],
      marque: ['', Validators.required],
      model: ['', Validators.required],
      annee: ['', Validators.required],
      clientId: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.loadClients();
  }

  loadClients(): void {
    this.clientService.getAllClients()
      .subscribe(clients => this.clients = clients);
  }

  onSubmit(): void {
    if (this.voitureForm.valid) {
      const clientId = this.voitureForm.get('clientId')?.value;
      this.voitureService.createVoiture(clientId, this.voitureForm.value)
        .subscribe(() => {
          this.router.navigate(['/voitures']);
        });
    }
  }
}
