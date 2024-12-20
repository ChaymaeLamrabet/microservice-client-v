import { Component, OnInit } from '@angular/core';
import { Voiture } from '../../models/voiture';
import { VoitureService } from '../../services/voiture.service';
import {RouterLink} from '@angular/router';
import {CommonModule} from '@angular/common';
import {MatIconModule} from '@angular/material/icon';

@Component({
  selector: 'app-voiture-list',
  standalone: true,
  imports: [
    RouterLink,
    CommonModule,
    MatIconModule
  ],
  templateUrl: './voiture-list.component.html'
})
export class VoitureListComponent implements OnInit {
  voitures: Voiture[] = [];

  constructor(private voitureService: VoitureService) { }

  ngOnInit(): void {
    this.loadVoitures();
  }

  loadVoitures(): void {
    this.voitureService.getAllVoitures()
      .subscribe(voitures => this.voitures = voitures);
  }
}
