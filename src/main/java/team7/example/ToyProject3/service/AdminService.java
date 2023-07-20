package team7.example.ToyProject3.service;

import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import team7.example.ToyProject3.domain.board.BoardStatus;
import team7.example.ToyProject3.domain.user.User;
import team7.example.ToyProject3.domain.user.UserRole;
import team7.example.ToyProject3.dto.AdminBoardDto;
import team7.example.ToyProject3.dto.AdminReportDto;
import team7.example.ToyProject3.dto.AllUsersInfoDto;
import team7.example.ToyProject3.repository.AdminRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private final SqlSessionFactory sqlSessionFactory;
    private final EmailService emailService;

    // 유저 리스트
    public List<AllUsersInfoDto> getAllUsers() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            return adminRepository.getAllUsers();
        }
    }

    // 유저 등급 변경
    public void updateRoleById(Long id, UserRole userrole) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.updateRoleById(id, userrole);

            User userData = adminRepository.findUserById(id);
            emailService.sendSimpleText(userData);

            sqlSession.commit();
        }
    }

    // 유저 정렬(게시글)
    public List<AllUsersInfoDto> getAllUsersOrderByBoard() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.getAllUsersOrderByBoard();
            return adminRepository.getAllUsersOrderByBoard();
        }
    }

    // 유저 정렬(댓글)
    public List<AllUsersInfoDto> getAllUsersOrderByReply() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.getAllUsersOrderByReply();
            return adminRepository.getAllUsersOrderByReply();
        }
    }

    // 게시글 목록 보기
    public List<AdminBoardDto> getAllBoards() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            return adminRepository.getAllBoards();
        }
    }

    // 게시글 상태 변경
    public void updateBoardStatus(Long id, BoardStatus boardStatus) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.updateBoardStatus(id, boardStatus);
            sqlSession.commit();
        }
    }

    // 게시글 삭제
    public void deleteBoardById(Long id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.deleteBoardById(id);
            sqlSession.commit();
        }
    }

    // 댓글 삭제
    public void deleteRepliesByBoardId(Long id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.deleteRepliesByBoardId(id);
            sqlSession.commit();
        }
    }

    // 신고 게시판
    public List<AdminReportDto> findReportsByBoardId() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            return adminRepository.findReportsByBoardId();
        }
    }

    // 신고 게시판 등급 변경
    public void updateBlackById(Long id, UserRole userrole) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.updateBlackById(id, userrole);
            sqlSession.commit();
        }
    }

    // 신고 승인
    public void updateReportBlackById(Long id, UserRole userrole) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.updateReportBlackById(id, userrole);
            sqlSession.commit();
        }
    }
    // 신고 거절
    public void deleteReportByBoardId(Long id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.deleteReportByBoardId(id);
            sqlSession.commit();
        }
    }

}