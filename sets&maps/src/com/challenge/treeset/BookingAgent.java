package com.challenge.treeset;

public class BookingAgent {

    public static void main(String[] args) {

        int row = 2;
        int seats = 100;
        Theatre paradise = new Theatre("Paradise", row, seats);
        paradise.printSeatMap();

        bookSeat(paradise, 'A', 9);

    }

    public static void bookSeat(Theatre theatre, char row, int seatNo) {
        String seat = theatre.reserveSeat(row, seatNo);
        if(seat != null) {
            System.out.println("Congratulations! Your seat is reserved. Your seat number - "+ seat);
            theatre.printSeatMap();
        } else {
            System.out.println("Sorry! Unable to reserve "+ row + seatNo);
        }
    }
}
