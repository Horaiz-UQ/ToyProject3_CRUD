package team7.example.ToyProject3.service;

import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import team7.example.ToyProject3.domain.board.BoardStatus;
import team7.example.ToyProject3.domain.user.UserRole;
import team7.example.ToyProject3.dto.AdminBoardDto;
import team7.example.ToyProject3.dto.AdminReportDto;
import team7.example.ToyProject3.repository.AdminRepository;
import team7.example.ToyProject3.dto.AllUsersInfoDto;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private final SqlSessionFactory sqlSessionFactory;


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
            sqlSession.commit();
        }
    }


    // 이메일 발송
    public void sendEmailToUser(Long userId, String subject, String message) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.sendEmailToUser(userId, subject, message);
            sqlSession.commit();
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
    public void updateBoardStatus(Integer id, BoardStatus boardStatus) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.updateBoardStatus(id, boardStatus);
            sqlSession.commit();
        }
    }

    // 게시글 삭제
    public void deleteBoardById(Integer id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.deleteBoardById(id);
            sqlSession.commit();
        }
    }

    // 댓글 삭제
    public void deleteRepliesByBoardId(Integer id) {
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

}