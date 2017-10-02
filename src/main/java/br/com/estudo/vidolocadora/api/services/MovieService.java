package br.com.estudo.vidolocadora.api.services;

import br.com.estudo.vidolocadora.api.entities.Movie;
import java.util.Optional;

public interface MovieService {

    /**
     * find movies by its title
     *
     * @param title
     * @return
     */
    Optional<Movie> findMovieByTitle(String title);


    /**
     * persist in database a Movie object
     *
     * @param movie
     * @return
     */
    Movie persist(Movie movie);
}
