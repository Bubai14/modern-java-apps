package com.challenge.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

record Player(List<Card> cards, String name){

    /**
     * Returns the list of players created on the count.
     * @param count
     * @return
     */
    public static List<Player> players(int count) {
        List<Player> players = new ArrayList<>(count);
        for(int i = 0; i < count; i++) {
            players.add(defaultPlayer("player" + (i+1)));
        }
        return players;
    }

    /**
     * Returns a default player with empty cards and default name
     *
     * @return
     */
    public static Player defaultPlayer(String name) {
        return new Player(new ArrayList<Card>(), name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name  +
                ", cards='" + cards + '\'' +
                '}';
    }
}

public class CardGame {

    public static void main(String[] args) {
        // Get the deck of cards
        List<Card> deck = Card.getStandardDeck();
        // Shuffle the cards
        Collections.shuffle(deck);
        Card.printDeck(deck, "All the cards in the deck", 4);
        //Create the players
        List<Player> players = Player.players(4);
        // Distribute the card to the players
        distributeCards(deck, players);
        System.out.println(players);

    }

    public static void distributeCards(List<Card> deck, List<Player> players) {
        int startDeckIndex = 0;
        int endDeckIndex = startDeckIndex + 3;
        for(var player : players) {
            player.cards().addAll(deck.subList(startDeckIndex, endDeckIndex));
            startDeckIndex = endDeckIndex;
            endDeckIndex = startDeckIndex + 3;
            if(startDeckIndex == deck.size()) {
                return;
            }
        }
    }

}
