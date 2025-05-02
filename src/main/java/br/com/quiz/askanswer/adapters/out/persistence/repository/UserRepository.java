package br.com.quiz.askanswer.adapters.out.persistence.repository;

import br.com.quiz.askanswer.adapters.out.persistence.entities.UserEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntities, UUID> {
}
