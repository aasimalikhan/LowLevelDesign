package org.example.solidprinciples.facadeDesignPattern.gptCode.goodCode;

public class HomeTheatreClient {
    public static void main(String[] args) {
        Amplifier amplifier = new Amplifier();
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amplifier, dvdPlayer, projector);
        homeTheaterFacade.setMovieSettings();
        homeTheaterFacade.playMovie("la la land");
    }
}
