import {Component, OnInit} from '@angular/core';
import {TeamService, TeamTableHeaders} from '../../services/team.service';
import {Observable} from 'rxjs';
import {Team} from '../../interfaces/team';
import {take} from 'rxjs/operators';
import {Country} from '../../interfaces/player';


@Component({
  selector: 'app-team-table',
  templateUrl: './team-table.component.html',
  styleUrls: ['./team-table.component.scss']
})

export class TeamTableComponent implements OnInit {
  //asincrónica
  public teams$: Observable<Team[]>;
  public tableHeaders = TeamTableHeaders;

  constructor(
    private teamService: TeamService,
  ) {
    this.teams$ = this.teamService.getTeams();
  }

  // ngOnInit() -> lugar para hacer peticiones
  ngOnInit(): void {
    this.teamService.getTeams().pipe(
      take(1)
    ).subscribe(teams => {
      if (teams.length === 0) {
        const team: Team = {
          name: 'NestorTeam',
          country: Country.Afghanistan,
          players: [],
        };
        this.teamService.addTeam(team)
      }
    });
  }

}
