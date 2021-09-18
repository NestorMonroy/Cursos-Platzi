import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AngularFireModule} from 'angularfire2';
import {AngularFireDatabaseModule} from 'angularfire2/database';
import {environment} from 'src/environments/environment';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PlayerService} from './services/player.service';
import {TeamService} from './services/team.service';
import {TeamTableComponent} from './ components/team-table/team-table.component';
import {PlayerTableComponent} from './ components/player-table/player-table.component';
import {PlayerDialogComponent} from './ components/player-dialog/player-dialog.component';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    TeamTableComponent,
    PlayerTableComponent,
    PlayerDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, // Creacion de formularios con angular
    //Inicializando Firebase
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireDatabaseModule,
  ],
  providers: [PlayerService, TeamService], //Poder acceder a los servicios
  bootstrap: [AppComponent]
})
export class AppModule {
}
