package br.com.quiz.askanswer.adapters.out.persistence.repository;

import br.com.quiz.askanswer.adapters.out.persistence.entities.AllAnswerRandomEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AllAnswerRandomRepository extends JpaRepository<AllAnswerRandomEntities, UUID> {

    @Query(value = "select answer from tb_respostas_random where category = :category and answer LIKE :initialAnswer% LIMIT 3", nativeQuery = true)
    List<String> findByCategory(String category, String initialAnswer);
}
