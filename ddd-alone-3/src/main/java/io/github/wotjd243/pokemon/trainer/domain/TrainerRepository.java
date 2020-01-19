package io.github.wotjd243.pokemon.trainer.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// Data JPA는 굉장히 자연스럽게 이미 DPI를 실현시키고 있다. (인프라가 도메인에 의존하는 형태 형성)
public interface TrainerRepository extends JpaRepository<Trainer, String> {
}
