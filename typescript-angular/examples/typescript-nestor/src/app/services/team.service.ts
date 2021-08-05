import { Injectable } from '@angular/core';
import { AngularFireDatabase, AngularFireList } from 'angularfire2/database';
import { AngularFireModule } from 'angularfire2';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Team } from '../interfaces/team';

export const TeamTableHeaders = ['name', 'country','players'];

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
          $key: c.key,
          ...c.payload.val()
        } as Team));
      })
    );
  }

  addTeams(team: Team) {
    return this.teamsDb.push(team)
  }

<<<<<<< HEAD
<<<<<<< HEAD
  deleteTeam(id: string) {
=======
  delerteTeam(id: string) {
>>>>>>> fd28d0ba3138a65154e5511e20aec28b409542dd
=======
  delerteTeam(id: string) {
>>>>>>> fd28d0ba3138a65154e5511e20aec28b409542dd
    this.db.list('/teams').remove(id);
  }

  editPlayer(newTeamData: any) {
    const $key = newTeamData.$key;
    delete (newTeamData.$key);
    this.db.list('/teams').update($key, newTeamData);
  }


<<<<<<< HEAD
<<<<<<< HEAD
}

=======
}
>>>>>>> fd28d0ba3138a65154e5511e20aec28b409542dd
=======
}
>>>>>>> fd28d0ba3138a65154e5511e20aec28b409542dd
