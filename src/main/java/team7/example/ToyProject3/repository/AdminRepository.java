package team7.example.ToyProject3.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import team7.example.ToyProject3.domain.board.BoardStatus;
import team7.example.ToyProject3.domain.user.Role;
import team7.example.ToyProject3.domain.user.User;
import team7.example.ToyProject3.domain.user.UserRole;
import team7.example.ToyProject3.dto.admin.AdminBoardDto;
import team7.example.ToyProject3.dto.admin.AdminReportDto;
import team7.example.ToyProject3.dto.admin.AllUsersInfoDto;

import java.util.List;

//@Repository
@Mapper
public interface AdminRepository {

    List<AllUsersInfoDto> getAllUsers();

    User findUserById(Long id);

    void updateRoleById(Long id, UserRole userrole);

    void sendEmailToUser(@Param("userId") Long userId, @Param("subject") String subject, @Param("message") String message);

    List<AdminBoardDto> getAllBoards();

    List<AllUsersInfoDto> getAllUsersOrderByBoard();

    List<AllUsersInfoDto> getAllUsersOrderByReply();

    Long deleteBoardById(Long id);

    Long deleteRepliesByBoardId(Long id);

    void updateBoardStatus(Long id, BoardStatus boardStatus);

    List<AdminReportDto> findReportsByBoardId();

    void updateBlackById(Long id, UserRole userrole);

    void updateReportBlackById(Long id, Role role);

    void deleteReportByBoardId(Long id);

    void updateBlacklistByBoardId(Long id, Role role, UserRole userRole);


}