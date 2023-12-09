package com.iiitd.stickhero;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return (o1.getPlayer_highestScore() - o2.getPlayer_highestScore());
    }
}

