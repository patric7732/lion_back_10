package sample.bean;

import java.util.List;

public class Game {
    private List<Player> list;

    public void play(){
        for(Player player:list){
            player.play();
        }
    }
}
