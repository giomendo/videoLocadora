package br.com.estudo.vidolocadora.api.repository;

import br.com.estudo.vidolocadora.api.entities.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional(readOnly = true)
public interface ShelfRepository extends JpaRepository<Shelf, Long> {

    List<Shelf> findByLocation(String location);
}
