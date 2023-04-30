package br.net.silva.daniel.api_brasileirao.domain.tournement.domain;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;

public class Substitution {
    private final Team team;
    private final Player playerIn;
    private final Player playerOut;

    public Substitution(Team team, Player playerIn, Player playerOut) {
        this.team = team;
        this.playerIn = playerIn;
        this.playerOut = playerOut;
    }
}
