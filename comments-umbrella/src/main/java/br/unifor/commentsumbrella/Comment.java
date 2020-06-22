package br.unifor.commentsumbrella;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("comment")
public class Comment implements Serializable {
    private int id;

    private String text;

    public Comment(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Comment(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

