package com.challenge.treeset;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Theatre {

    private NavigableSet<Seat> seats;
    private String theatreName;
    private Integer seatsInRow;

    public Theatre(String theatreName, int numbersOfRows, int totalSeats) {
        this.theatreName = theatreName;
        this.seatsInRow = totalSeats / numbersOfRows;
        this.seats =  new TreeSet<>();
        for(int seat = 0; seat < totalSeats; seat++) {
            char rowChar = (char) ( seat / totalSeats + (int) 'A');
            int seatNumber = seat % seatsInRow + 1;
            seats.add(new Seat(rowChar, seatNumber));
        }
    }

    public void printSeatMap() {
        String lineSeparator = "-".repeat(30);
        System.out.println(lineSeparator);
        System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n", lineSeparator, theatreName);
        int index = 0;
        for (Seat s : seats) {
            System.out.printf("%-8s%s", s.seatNumber + ((s.reserved) ? "(\u25CF)" : ""),
                    ((index++ + 1) % seatsInRow == 0) ? "\n" : "");
        }
        System.out.println(lineSeparator);
    }

    public String reserveSeat(char row, int seatNumber) {
        Seat requestedSeat = new Seat(row, seatNumber);
        Seat requested = seats.floor(requestedSeat);

        if(requested == null || !requested.seatNumber.equals(requestedSeat.seatNumber)) {
            System.out.println("--> No such seat: " + requestedSeat);
            System.out.printf(": Seat must be between %s and %s%n",
                    seats.first().seatNumber, seats.last().seatNumber);
        } else {
            if(!requested.reserved) {
                requested.reserved = true;
                return requested.seatNumber;
            } else {
                System.out.println("Seat's already reserved");
            }
        }
        return null;
    }


    class Seat implements Comparable<Seat>{

        private boolean reserved;
        private String seatNumber;

        public Seat(Character row, int seatNo) {
             this.seatNumber = "%c%03d".formatted(row, seatNo).toUpperCase();
        }

        @Override
        public String toString() {
            return "Seat - " + reserved + seatNumber;
        }

        @Override
        public int compareTo(Seat o) {
            return seatNumber.compareTo(o.seatNumber);
        }
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "seats=" + seats +
                ", theatreName='" + theatreName + '\'' +
                ", seatsInRow=" + seatsInRow +
                '}';
    }
}
