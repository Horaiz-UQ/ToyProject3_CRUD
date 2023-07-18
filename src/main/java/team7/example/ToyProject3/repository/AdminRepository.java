package team7.example.ToyProject3.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import team7.example.ToyProject3.domain.board.BoardStatus;
import team7.example.ToyProject3.domain.user.UserRole;
import team7.example.ToyProject3.dto.AdminBoardDto;
import team7.example.ToyProject3.dto.AllUsersInfoDto;

import java.util.List;

//@Repository
@Mapper
public interface AdminRepository {

    List<AllUsersInfoDto> getAllUsers();

    void updateRoleById(Long id, UserRole userrole);

    void sendEmailToUser(@Param("userId") Long userId, @Param("subject") String subject, @Param("message") String message);

    List<AdminBoardDto> getAllBoards();

    Integer deleteBoardById(Integer id);

    Integer deleteRepliesByBoardId(Integer id);

    void updateBoardStatus(Integer id, BoardStatus boardStatus);

}