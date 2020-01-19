package io.github.wotjd243.pokemon.example.dtovo;

// VO
// 이 VO를 외부에 노출시킬건지, DTO를 따로 만들지는 상황에 맞게 판단해라
public class Content {

    private String title;
    private String body;

    public Content(String title, String body) {
        this.title = title;
        this.body = body;
    }

    static Content valueOf(Content content) {

        return new Content(content.getTitle(), content.getBody());
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
