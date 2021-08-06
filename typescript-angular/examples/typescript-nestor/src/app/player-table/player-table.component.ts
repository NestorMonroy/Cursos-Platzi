import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { take } from 'rxjs/operators';
import { Player } from '../interfaces/player';
import { PlayerService } from '../services/player.service';
import { TeamService } from '../services/team.service';

@Component({
  selector: 'app-player-table',
  templateUrl: './player-table.component.html',
  styleUrls: ['./player-table.component.scss']
})
export class PlayerTableComponent implements OnInit {
  public players$!: Observable<Player[]>
  //public selectedPlayer: Player;
  public showModal = false;

  constructor(
    private playerService: PlayerService,
    private teamService: TeamService,
  ) { }

  ngOnInit(): void {
    this.players$ = this.playerService.getPlayers();
  }

  newPlayer() {
    this.showModal = true;
    //this.selectedPlayer = [];
    setTimeout(() => {
      window.location.replace('#open-modal');
    }, 0);
  }



}