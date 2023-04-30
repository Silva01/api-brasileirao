package br.net.silva.daniel.api_brasileirao.domain.transfer.domain;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transfer {

    private final Player player;
    private final Team originTeam;
    private final Team destinyTeam;
    private final LocalDate transferDate;
    private final BigDecimal transferValue;

    public Transfer(Player player, Team originTeam, Team destinyTeam, LocalDate transferDate, BigDecimal transferValue) {
        this.player = player;
        this.originTeam = originTeam;
        this.destinyTeam = destinyTeam;
        this.transferDate = transferDate;
        this.transferValue = transferValue;
    }
}
