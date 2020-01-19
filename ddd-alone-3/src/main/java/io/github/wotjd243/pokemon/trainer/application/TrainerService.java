package io.github.wotjd243.pokemon.trainer.application;

import io.github.wotjd243.pokemon.pokemon.domain.CaughtPokemonEvent;
import io.github.wotjd243.pokemon.trainer.domain.Trainer;
import io.github.wotjd243.pokemon.trainer.domain.TrainerRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional  // Transaction 관리는 서비스의 아주 중요한 기능! (+ 제어 흐름 관리)
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public Trainer join(final String id) {
        return trainerRepository.save(new Trainer(id));
    }

    public Trainer levelUp(String id) {
        Trainer trainer = trainerRepository.findById(id).orElse(null);
        trainer.levelUp();
        return trainer;
    }

    // 안티 패턴일 때의 예시
    /*public void addPokemon(final int number, final String name) {

        final Trainer trainer = trainerRepository.findById("poppo").orElseThrow(IllegalArgumentException::new);
        trainer.addPokemon(number, name);
    }*/

    // @TransactionalEventListener -> 트랜잯녀 묶지 않아도 될 때 사용(commit 된 후에 이 이벤트가 작동한다)
    @EventListener // 트랜잭션을 묶어야 할 경우 사용
    public void addPokemon(final CaughtPokemonEvent event) {

        final Trainer trainer = trainerRepository.findById("poppo").orElseThrow(IllegalArgumentException::new);
        trainer.addPokemon(event.getNumber(), event.getName());
    }
}
