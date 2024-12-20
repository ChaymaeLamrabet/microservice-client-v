import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Voiture } from '../models/voiture';

@Injectable({
  providedIn: 'root'
})
export class VoitureService {
  private apiUrl = 'http://localhost:8888/service-voiture';

  constructor(private http: HttpClient) { }

  getAllVoitures(): Observable<Voiture[]> {
    return this.http.get<Voiture[]>(`${this.apiUrl}/voitures`);
  }

  getVoitureById(id: number): Observable<Voiture> {
    return this.http.get<Voiture>(`${this.apiUrl}/voitures/${id}`);
  }

  getVoituresByClientId(clientId: number): Observable<Voiture[]> {
    return this.http.get<Voiture[]>(`${this.apiUrl}/voitures/client/${clientId}`);
  }

  createVoiture(clientId: number, voiture: Voiture): Observable<Voiture> {
    return this.http.post<Voiture>(`${this.apiUrl}/voitures/${clientId}`, voiture);
  }

  updateVoiture(id: number, voiture: Voiture): Observable<Voiture> {
    return this.http.put<Voiture>(`${this.apiUrl}/voitures/${id}`, voiture);
  }
}
