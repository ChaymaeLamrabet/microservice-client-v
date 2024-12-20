import {Client} from './client';

export interface Voiture {
  id?: number;
  matricule: string;
  marque: string;
  model: string;
  annee: string;
  clientId: number;
  client?: Client;
}
