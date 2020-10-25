package org.wecancodeit.basketballmtrushmore;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerRepositoryTest {

    private PlayerRepository underTest;
    Player playerOne = new Player(1l, "player one name", "","rings");
    Player playerTwo = new Player(2l, "player two name", "description","rings");
    Player playerThree = new Player(3l, "player three name", "description","rings");
    Player PlayerFour = new Player(4l, "player four name", "description","rings");

    @Test
    public void shouldFindOneRushmorePlayer(){
        underTest = new PlayerRepository(playerOne);
        Player foundPlayer = underTest.findOne(1l);
        assertEquals(playerOne, foundPlayer);
    }

    @Test
    public void FindRushmorePlayerOneAndTwoAndThree(){
        underTest = new PlayerRepository(playerOne,playerTwo,playerThree);
        Collection<Player> foundPlayers = underTest.findAll();
        assertThat(foundPlayers).contains(playerOne, playerTwo, playerThree);
    }







}





