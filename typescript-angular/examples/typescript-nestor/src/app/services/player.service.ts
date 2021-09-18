import { Injectable } from '@angular/core';
import { AngularFireDatabase, AngularFireList } from 'angularfire2/database';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Player } from '../interfaces/player';

@Injectable({
  //Crear una instancia
  providedIn: 'root'
})
export class PlayerService {
  private playersDb: AngularFireList<Player>;

  constructor(private db: AngularFireDatabase) {
    //Acedemos a la base de datos de firebase //
    //De que tabla obtendremos los datos, y como ordenaremos la referencia
    this.playersDb = this.db.list('/players', ref => ref.orderByChild('name'));
  }

  // Regresa un Observable
  // getPlayers(): Observable<Player[]> {
  // Obtenemos la información, con la key representativa dentro de firebase snapshotChanges()
  //  this.playersDb = this.db.list('/players', ref => ref.orderByChild('name'))
  // }

  getPlayers(): Observable<Player[]> {
    //Obtenemos la información, con la key representativa dentro de firebase snapshotChanges()
    //snapshotChanges, obtiene la información, cuando nosotros pedimos la información
    return this.playersDb.snapshotChanges().pipe(
      map(changes => {
        return changes.map(c => ({
          $key: c.payload.key,
          ...c.payload.val() //Se agrega la información adicional del objeto
        } as Player));
      })
    );
  }

  addPlayer(player: Player) {
    return this.playersDb.push(player)
  }

  deletePlayer(id: string) {
    this.db.list('/players').remove(id);
  }

  editPlayer(newPlayerData: any) {
    const $key = newPlayerData.$key;
    //Eliminamos la key
    delete(newPlayerData.$key);
    //Actualizar la información
    this.db.list('/players').update($key, newPlayerData);
  }

}



