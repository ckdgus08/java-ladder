package nextstep.ladder.domain;

import nextstep.ladder.domain.winningPrize.WinningPrize;
import nextstep.ladder.exception.NotEnoughtWinningPrizeException;
import nextstep.ladder.exception.PlayerNotParticipateException;

import java.util.Collections;
import java.util.List;

public class BoardConsumer {

    private static final int ZERO = 0;
    private List<Player> players;
    private List<WinningPrize> winningPrizes;

    public BoardConsumer(List<Player> players, List<WinningPrize> winningPrizes) {
        validWinningPrizesSize(players, winningPrizes);
        this.players = players;
        this.winningPrizes = winningPrizes;
    }

    private void validWinningPrizesSize(List<Player> players, List<WinningPrize> winningPrizes) {
        if (players.size() != winningPrizes.size()) {
            throw new NotEnoughtWinningPrizeException();
        }
    }

    public void validateNotParticipatePlayer(List<Player> players) {
        if ((int) players.stream()
                .filter((player -> !this.players.contains(player)))
                .count() > ZERO) {
            throw new PlayerNotParticipateException();
        }
    }

    public int getPlayerIndex(Player player) {
        return players.indexOf(player);
    }

    public WinningPrize getWinningPrize(int index) {
        return winningPrizes.get(index);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<WinningPrize> getWinningPrizes() {
        return Collections.unmodifiableList(winningPrizes);
    }
}
