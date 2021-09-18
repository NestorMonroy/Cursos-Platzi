import { Injectable } from '@angular/core';
import { AngularFireDatabase, AngularFireList } from 'angularfire2/database';
import { AngularFireModule } from 'angularfire2';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Team } from '../interfaces/team';

export const TeamTableHeaders = ['Name', 'Country','Players'];

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private teamsDb: AngularFireList<Team>;

  constructor(private db:AngularFireDatabase) {
    //Popular **
    this.teamsDb = this.db.list('/teams', ref => ref.orderByChild('name'));
  }

  //Funcion que retorna un Observable
  getTeams(): Observable<Team[]> {
    return this.teamsDb.snapshotChanges().pipe(
      map(changes => {
        return changes.map(c => ({
          $key: c.payload.key,
          ...c.payload.val()
        } as Team));
      })
    );
  }

  addTeam(team: Team) {
    return this.teamsDb.push(team)
  }

  deleteTeam(id: string) {
    this.db.list('/teams').remove(id);
  }

  editTeam(newTeamData: any) {
    const $key = newTeamData.$key;
    delete (newTeamData.$key);
    this.db.list('/teams').update($key, newTeamData);
  }


}


