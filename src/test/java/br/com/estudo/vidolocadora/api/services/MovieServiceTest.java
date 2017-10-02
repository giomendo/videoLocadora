package br.com.estudo.vidolocadora.api.services;

import br.com.estudo.vidolocadora.api.entities.Movie;
import br.com.estudo.vidolocadora.api.repository.MovieRepository;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MovieServiceTest {

    @MockBean
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    private static final String TITLE="Titulo 1";

    @Before
    public void setUp(){
        BDDMockito.given(movieRepository.findByTitle(Mockito.anyString())).willReturn(new Movie());
        BDDMockito.given(movieRepository.save(Mockito.any(Movie.class))).willReturn(new Movie());
    }

    @Test
    public void testFindMovieByTitle() {
        Optional<Movie> movie = movieService.findMovieByTitle(TITLE);

        assertTrue(movie.isPresent());
    }

    @Test
    public void testPersistMovie() {
        Movie movie = movieService.persist(new Movie());

        assertNotNull(movie);
    }
}
