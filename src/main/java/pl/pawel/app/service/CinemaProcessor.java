package pl.pawel.app.service;

import pl.pawel.app.domain.cinema.CinemaPostProcessing;
import pl.pawel.app.domain.cinema.CinemaProcessing;

public interface CinemaProcessor {
    public CinemaPostProcessing process(CinemaProcessing processing);
}
