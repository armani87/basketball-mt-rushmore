package org.wecancodeit.basketballmtrushmore;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@WebMvcTest(PlayerController.class)
public class PlayerControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerRepository playerRepo;


    @Mock
    private Player playerOne;

    @Mock
    private Player playerTwo;


    @Test
    public void OnePlayerInPlayerTemplate() throws Exception {
        Long playerOneId = 1L;
        when(playerRepo.findOne(playerOneId)).thenReturn(playerOne);
        mockMvc.perform(get("/Player?id=1")).andExpect(status().isOk())
                .andExpect(view().name("playersTemplate"));
    }

    @Test
    public void FindPlayerOneInModel() throws Exception {
        Long playerOneId = 1L;
        when(playerRepo.findOne(playerOneId)).thenReturn(playerOne);
        mockMvc.perform(get("Player?id=1?"))
                .andExpect(model().attribute("playerModel", playerOne));
    }

    @Test
    public void ForAllPlayerInPlayersTemplate() throws Exception {
        mockMvc.perform(get("/Players")).andExpect(status().isOk())
                .andExpect(view().name("PlayersTemplate"));
    }

    @Test
    public void ForAllPlayersInModel() throws Exception {
        Collection<Player> allPlayersInModel = Arrays.asList(playerOne, playerTwo);
        when(playerRepo.findAll()).thenReturn(allPlayersInModel);
        mockMvc.perform(get("/Players"))
                .andExpect(model().attribute("playersModel",allPlayersInModel));
    }

}
