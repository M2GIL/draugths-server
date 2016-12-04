package fr.univ.iataaaserver.service.game.util;

import fr.univ.iataaaserver.domain.game.Board;
import fr.univ.iataaaserver.domain.game.Case;
import fr.univ.iataaaserver.domain.game.EnumPlayer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RulesTest {

    @Test
    public void getAvailableMovesStart() {
        List<Board<Case>> expectedBoard = new ArrayList<>();

        Case[] cases = TestUtil.createBoard(
                new HashMap.SimpleEntry<>(45, Case.WHITE_PIECE)
        );

        Case[] expected = TestUtil.moveCaseFrom(cases, 45, 40);
        expectedBoard.add(new Board<Case>(expected));

        Board<Case> board = new Board(cases);
        List<Board<Case>> res = Rules.getAvailableMoves(board, EnumPlayer.PLAYER_1);

        assertThat(res).containsOnlyElementsOf(expectedBoard);
    }

}
