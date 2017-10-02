package br.com.estudo.vidolocadora.api.repository;

import br.com.estudo.vidolocadora.api.entities.Movie;
import br.com.estudo.vidolocadora.api.entities.Shelf;
import br.com.estudo.vidolocadora.api.enums.Category;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShelfRepository shelfRepository;

    private Long shelfId;

    private static final String DIRECTOR = "Fulano de Tal";
    private static final String TITLE = "Filme 1";


    @Before
    public void setUp() {
        Shelf shelf = this.shelfRepository.save(getTestShelf());
        shelfId = shelf.getId();
        this.movieRepository.save(getTestMovie(shelf));
        this.movieRepository.save(getTestMovie(shelf));
    }

    @After
    public void tearDown() {
        this.shelfRepository.deleteAll();
    }

    @Test
    public void testFindMoviesByShelfId() {
        List<Movie> movies = movieRepository.findByShelfId(this.shelfId);

        assertEquals(2, movies.size());
    }

    @Test
    public void testFindMoviesByShelfIdPaged() {
        PageRequest pageRequest = new PageRequest(0, 10);
        Page<Movie> movies = movieRepository.findByShelfId(this.shelfId, pageRequest);

        assertEquals(2, movies.getTotalElements());

    }

    private Shelf getTestShelf() {
        Shelf shelf = new Shelf();
        shelf.setLocation("1A");

        return shelf;
    }

    private Movie getTestMovie(Shelf shelf){
        Movie movie = new Movie();
        movie.setCategory(Category.ACTION);
        movie.setDirector(DIRECTOR);
        movie.setTitle(TITLE);
        movie.setShelf(shelf);

        return movie;
    }


}
