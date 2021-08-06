import { Injectable } from '@angular/core';
import { AngularFireDatabase, AngularFireList } from 'angularfire2/database';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Player } from '../interfaces/player';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {
  private playersDb: AngularFireList<Player>;

  constructor(private db: AngularFireDatabase) {
    //Acedemos a la base de datos de firebase // 
    this.playersDb = this.db.list('/players', ref => ref.orderByChild('name'));
  }

  //Regresa un Observable 
  // getPlayers(): Observable<Player[]> {
  //   //Obtenemos la informacion, con la key representativa dentro de firebase snapshotChanges()
  //   this.playersDb = this.db.list('/players', ref => ref.orderByChild('name'))
  // }

  getPlayers(): Observable<Player[]> {
    //Obtenemos la informacion, con la key representativa dentro de firebase snapshotChanges()
    return this.playersDb.snapshotChanges().pipe(
      map(changes => {
        return changes.map(c => ({
          $key: c.key,
          ...c.payload.val() //Se agrega la informacion adicional del objecto
    
        } as Player));
      })
    );
  }

  addPlayer(player: Player) {
    return this.playersDb.push(player)
  }

  deletePlayer(id: string) {
    this.db.list('/teams').remove(id);
    this.db.list('/players').remove(id);
  }

  editPlayer(newPlayerData: any) {
    const $key = newPlayerData.$key;
    //Eliminamos la key
    delete (newPlayerData.$key);
    //Actualizar la informacion
    this.db.list('/players').update($key, newPlayerData);
  }

    
}



