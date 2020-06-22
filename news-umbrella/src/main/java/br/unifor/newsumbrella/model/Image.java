package br.unifor.newsumbrella.model;

import javax.persistence.*;

@Table(name="image")
@Entity
public class Image {
    @Id // Primary Key
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String source;

    @ManyToOne
    News news;

    public Image() {  }

    public Image(String source) {
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
