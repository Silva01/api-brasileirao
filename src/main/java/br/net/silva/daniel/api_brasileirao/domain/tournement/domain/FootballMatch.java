package br.net.silva.daniel.api_brasileirao.domain.tournement.domain;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;

import java.util.List;

public class FootballMatch {
    private final Team teamHome;
    private final Team teamAway;
    private int goalsHome;
    private int goalsAway;
    private boolean isFinished;
    private boolean isStartedBreak;
    private boolean isStarted;
    private final List<Player> redCardsPlayersList;
    private final List<Player> yellowCardsPlayersList;

    public FootballMatch(
            Team teamHome,
            Team teamAway,
            List<Player> redCardsPlayersList,
            List<Player> yellowCardsPlayersList) {
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.goalsHome = 0;
        this.goalsAway = 0;
        this.isFinished = false;
        this.isStartedBreak = false;
        this.isStarted = false;
        this.redCardsPlayersList = redCardsPlayersList;
        this.yellowCardsPlayersList = yellowCardsPlayersList;
    }

    public void goalHome() {
        this.goalsHome++;
    }

    public void goalAway() {
        this.goalsAway++;
    }

    public void startMatch() {
        this.isStarted = true;
        this.isStartedBreak = false;
        this.isFinished = false;
    }

    public void startBreak() {
        this.isStartedBreak = true;
        this.isStarted = false;
        this.isFinished = false;
    }

    public void finishMatch() {
        this.isFinished = true;
        this.isStarted = false;
        this.isStartedBreak = false;
    }
}
