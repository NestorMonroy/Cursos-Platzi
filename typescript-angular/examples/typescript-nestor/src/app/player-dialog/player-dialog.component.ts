import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { take } from 'rxjs/operators';
import { Country, Player, SquadNumber } from '../interfaces/player';
import { Team } from '../interfaces/team';
import { PlayerService } from '../services/player.service';
import { TeamService } from '../services/team.service';

declare type CategoryType = keyof typeof Country;

@Component({
  selector: 'app-player-dialog',
  templateUrl: './player-dialog.component.html',
  styleUrls: ['./player-dialog.component.scss']
})

export class PlayerDialogComponent implements OnInit {
  @Input() player!: Player;
  @Output() closeDialog: EventEmitter<boolean> = new EventEmitter();

  private team!: Team;
  public countries = Object.keys(Country).map((key) => ({
    label: key,
    key: Country[key as CategoryType],
  }));

  public squadNumber = Object.keys(SquadNumber)
    .slice(Object.keys(SquadNumber).length / 2)
    .map((key: any) => ({
      label: key,
      key: SquadNumber[key],
    }));

  constructor(
    private playerService: PlayerService,
    private teamService: TeamService
  ) { }

  ngOnInit(): void {
    this.teamService
      .getTeams()
      .pipe(take(1))
      .subscribe((teams) => {
        if (teams.length > 0) {
          this.team = teams[0];
        }
      });
  }

  private newPlayer(playerFormValue: Player) {
    const key = this.playerService.addPlayer(playerFormValue).key;
    const playerFormValueKey = {
      ...playerFormValue,
      key
    };
    const formattedTeam = {
      ...this.team,
      players: [
        ...(this.team.players ? this.team.players : []), 
        playerFormValueKey
      ]
    };
    this.teamService.editTeam(formattedTeam);
  }

  
  private editPlayer(playerFormValue: NgForm) {
    const playerFormValueWithKey = { ...playerFormValue, $key: this.player.$key };
    const playerFormValueWithFormattedKey = { ...playerFormValue, key: this.player.$key };
    delete playerFormValueWithFormattedKey.key;


  }

  onSubmit(playerForm: NgForm) {
    const playerFormValue = { ...playerForm.value };
    if (playerForm.valid) {
      playerFormValue.leftFooted = playerFormValue.leftFooted === '' ? false : playerFormValue.leftFooted;
    }
    this.newPlayer(playerFormValue);
    window.location.replace('#');
  }

  onClose() {
    this.closeDialog.emit(true);
  }

}
