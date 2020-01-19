package io.github.wotjd243.pokemon.example.dtovo;

// Entity
public class Post {

    private Long id;
    private Content content;    // 이렇게 되면 DTO 없이 VO를 외부에 노출시킬 수 있다.

    public void update(final Content content) {
        this.content = Content.valueOf(content);
    }
}
