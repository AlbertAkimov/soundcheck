package net.space.model;

import javax.persistence.*;

/**
 * @Author A.Albert
 * @Data 8/31/17
 * @Time 10:25 AM
 * @Version 1.0
 * @Info empty
 */
@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME_AUTHOR")
    private String nameAuthor;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MESSAGE")
    private String message;

    public Contact() {}

    public Contact(String nameAuthor, String email, String message) {
        this.nameAuthor = nameAuthor;
        this.email = email;
        this.message = message;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nameAuthor='" + nameAuthor + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
