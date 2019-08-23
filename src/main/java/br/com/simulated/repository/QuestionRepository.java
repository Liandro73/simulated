package br.com.simulated.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simulated.models.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Long>{

}
