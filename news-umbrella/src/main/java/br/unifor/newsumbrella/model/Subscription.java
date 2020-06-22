package br.unifor.newsumbrella.model;


import javax.persistence.*;

@Table(name= "subscription")
@Entity
public class Subscription{
    @Id // Primary Key
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String user_email;

    @ManyToOne
    Category category;
    public Subscription(String user_email) {
        this.user_email = user_email;
    }

    public Subscription(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
