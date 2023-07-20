package team7.example.ToyProject3.dto.admin;

import lombok.*;
import team7.example.ToyProject3.domain.board.BoardStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdminBoardDto {
    private Long id;
    private String nickname;
    private String title;
    private Timestamp createdAt;
    @Enumerated(value = EnumType.STRING)
    public BoardStatus boardStatus;
}
