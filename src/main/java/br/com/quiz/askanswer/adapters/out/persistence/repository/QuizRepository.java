package br.com.quiz.askanswer.adapters.out.persistence.repository;

import br.com.quiz.askanswer.adapters.out.persistence.entities.QuizEntities;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntities, UUID> {

    @Query(nativeQuery = true, value = "SELECT EXISTS (\n" +
            "    SELECT *\n" +
            "    FROM tb_quiz\n" +
            "    WHERE id_user = :idUser\n" +
            ");")
    Boolean existsByUser(UUID idUser);

    List<QuizEntities> findByUserEntitiesIdUser(UUID idUser, Sort sort);
}
