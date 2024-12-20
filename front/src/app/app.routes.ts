import { Routes } from '@angular/router';
import { ClientListComponent } from './components/client-list/client-list.component';
import { VoitureListComponent } from './components/voiture-list/voiture-list.component';
import { AddVoitureComponent } from './components/add-voiture/add-voiture.component';

export const routes: Routes = [  // Ajout du mot-clé 'export'
  { path: '', redirectTo: '/clients', pathMatch: 'full' },
  { path: 'clients', component: ClientListComponent },
  { path: 'voitures', component: VoitureListComponent },
  { path: 'add-voiture', component: AddVoitureComponent }
];
