package team7.example.ToyProject3.domain.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team7.example.ToyProject3.domain.board.Board;
import team7.example.ToyProject3.domain.user.User;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false, length = 100)
    private String description;

    @ManyToOne
    private Board board;

    @ManyToOne
    private User user;

}
