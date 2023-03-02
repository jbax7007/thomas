package thomas777.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "t_article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long articleID;
    @Column(name = "title")
    private String articleTitle;
    @Column(name = "description")
    private String articleDescription;
    @Column(name = "link")
    private String articleLink;

}
