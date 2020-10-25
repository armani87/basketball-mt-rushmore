package org.wecancodeit.basketballmtrushmore;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class PlayerRepository {

    Map<Long, Player> playersList = new HashMap<>();


    public PlayerRepository(){
        Player Lebron = new Player(1L, "Lebron James", "The King of the court.","4" );
        Player Mike = new Player(2L,"Micheal Jordan", "The Championship will","6");
        Player Cap = new Player(3L,"Kareem Abdul-Jabbar", "The Unstoppable Move","6");
        Player Magic = new Player(4L,"Magic Johnson", "The Book of Magic","5");


        playersList.put(Lebron.getId(), Lebron);
        playersList.put(Mike.getId(), Mike);
        playersList.put(Cap.getId(), Cap);
        playersList.put(Magic.getId(), Magic);

    }

    //constructor for testing
    public PlayerRepository(Player ...playersToAdd ) {
        for(Player player: playersToAdd){
            playersList.put(player.getId(), player);

        }
    }

    public Player findOne(long id){
        return playersList.get(id);
    }

    public Collection<Player> findAll() {
        return playersList.values();
    }

}
