package thomas777.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "t_videoDetails")
public class VideoDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long videoDetailsID;
    @Column(name = "videoId")
    private long videoID;
    @Column(name = "tagID")
    private long tagID;
}