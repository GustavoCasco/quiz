package br.com.quiz.askanswer.adapters.out.persistence.repository;

import br.com.quiz.askanswer.adapters.out.persistence.entities.QuizEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntities, UUID> {
}
