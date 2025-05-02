package br.com.quiz.askanswer.adapters.out.persistence.repository;

import br.com.quiz.askanswer.adapters.out.persistence.entities.AskEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AskRepository extends JpaRepository<AskEntities, UUID> {


    @Query(nativeQuery = true, value = "select distinct(categoria) from tb_perguntas")
    List<String> findByAllCategory();

    @Query(value = "SELECT * FROM tb_perguntas WHERE categoria = :categoria ORDER BY RANDOM()", nativeQuery = true)
    List<AskEntities> findByAskByCategory(@Param("categoria") String categoria);
}
