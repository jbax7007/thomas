package thomas777.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "t_video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long videoID;
    @Column(name = "title")
    private String videoTitle;
    @Column(name = "description")
    @Type(type="text")
    private String videoDescription;
    @Column(name = "link")
    private String videoLink;
    @Column(name = "embeddedLink")
    @Type(type="text")
    private String videoEmbeddedLink;
    @Column(name = "date")
    private String videoDate;

}
