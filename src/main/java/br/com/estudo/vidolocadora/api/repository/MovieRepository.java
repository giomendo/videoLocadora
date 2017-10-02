package br.com.estudo.vidolocadora.api.repository;

import br.com.estudo.vidolocadora.api.entities.Movie;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional(readOnly = true)
@NamedQueries({
        @NamedQuery(name = "MovieRepository.findByShelfId",
        query = "SELECT mov FROM Movies mov WHERE mov.shelf.id = :shelfId") })
public interface MovieRepository extends JpaRepository<Movie, Long>{

    Movie findByTitle(String Title);

    List<Movie> findByShelfId(@Param("shelfId") Long shelfId);

    Page<Movie> findByShelfId(@Param("shelfId")Long shelfId, Pageable pageable);

}
