package cvut.fel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
@NamedQueries({
        @NamedQuery(name = "Book.findByName", query = "SELECT u FROM Book u WHERE u.name = :name"),
})
@Getter @Setter
public class Book extends AbstractEntity{

    @Column(unique = true)
    @NotNull
    private String ISBN;
    private Date published;

    public Book() {
    }

    public Book(String name) {
        this();
        this.name = name;
    }

    public Date getPublished() {
        return (Date) published.clone();
    }

    public void setPublished(Date published) {
        this.published = (Date) published.clone();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", published='" + published + '\'' +
                '}';
    }

}
