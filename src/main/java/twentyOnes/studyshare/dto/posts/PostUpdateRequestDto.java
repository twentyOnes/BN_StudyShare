package twentyOnes.studyshare.dto.posts;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateRequestDto {
    private String postText;

}
