package org.example.solidprinciples.facadeDesignPattern.gptCode.badCode;

public class HomeTheaterClient {
    public static void main(String[] args) {
        Amplifier amplifier = new Amplifier();
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();

        amplifier.setVolume(20);
        dvdPlayer.play("la la land");
        projector.wideScreenMode();
    }
}
