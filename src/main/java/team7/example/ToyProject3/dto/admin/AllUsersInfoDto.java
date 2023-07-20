package team7.example.ToyProject3.dto.admin;

import lombok.*;
import team7.example.ToyProject3.domain.user.UserRole;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AllUsersInfoDto {
    private Integer id;
    private String name;
    private String nickname;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private UserRole userrole;
    private Integer qtyOfBoard;
    private Integer qtyOfReply;
}
