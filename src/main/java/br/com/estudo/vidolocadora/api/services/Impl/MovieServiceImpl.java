package br.com.estudo.vidolocadora.api.services.Impl;

import br.com.estudo.vidolocadora.api.entities.Movie;
import br.com.estudo.vidolocadora.api.repository.MovieRepository;
import br.com.estudo.vidolocadora.api.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        log.info("finding movie by tile {}", title);
        return Optional.ofNullable(this.movieRepository.findByTitle(title));
    }

    @Override
    public Movie persist(Movie movie) {
        log.info("persisting movie {}", movie);
        return this.movieRepository.save(movie);
    }
}
