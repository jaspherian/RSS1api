package rss1spring.crudtest.items;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("SELECT i FROM Item i WHERE ( ?1 is NULL or (CONVERT(i.id,CHAR(32)) LIKE %?1% or i.name LIKE %?1% or i.description LIKE %?1% ) )")
    Page<Item> filterItems(String search, Pageable pageable);

}
