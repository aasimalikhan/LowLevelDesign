package org.example.solidprinciples.facadeDesignPattern.gptCode.goodCode;

public class HomeTheaterFacade {
    private Amplifier amplifier;
    private DVDPlayer dvdPlayer;
    private Projector projector;

    public HomeTheaterFacade(Amplifier amplifier, DVDPlayer dvdPlayer, Projector projector)
    {
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
    }

    public void setDefaultSettings()
    {
        amplifier.setVolume(20);
    }

    public void playMovie(String movieName)
    {
        dvdPlayer.play(movieName);
    }
    public void setMovieSettings()
    {
        amplifier.setVolume(30);
        projector.wideScreenMode();
    }
}
