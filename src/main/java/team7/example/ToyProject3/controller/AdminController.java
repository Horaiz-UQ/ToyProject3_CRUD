package team7.example.ToyProject3.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team7.example.ToyProject3.domain.board.BoardStatus;
import team7.example.ToyProject3.domain.user.UserRole;
import team7.example.ToyProject3.service.AdminService;
import team7.example.ToyProject3.dto.AdminBoardDto;
import team7.example.ToyProject3.dto.AllUsersInfoDto;

import java.util.List;


@Controller
@AllArgsConstructor
public class AdminController {

    private AdminService adminService;

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "admin";
    }


    // 유저 리스트
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<AllUsersInfoDto> users = adminService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    // 유저 등급 변경
    @PostMapping("/users/{id}/userrole")
    public String updateUserRole(@PathVariable Long id, @RequestParam UserRole userrole) {
        adminService.updateRoleById(id, userrole);
        return "redirect:/users";
    }

    // 게시글 리스트
    @GetMapping("/userboard")
    public String getAllBoards(Model model) {
        List<AdminBoardDto> adminBoardDto = adminService.getAllBoards();
        model.addAttribute("userboard", adminBoardDto);
        return "userboard";
    }

    // 게시글 상태 업데이트
    @PostMapping("/userboard/{id}/boardStatus")
    public String updateBoardStatus(@PathVariable Integer id, @RequestParam BoardStatus boardStatus) {
        adminService.updateBoardStatus(id, boardStatus);
        return "redirect:/userboard";
    }

    // 게시글 삭제
    @PostMapping("/boardList/{id}/delete")
    public String deleteBoard(@PathVariable(name = "id") Integer id) {

        adminService.deleteRepliesByBoardId(id);

        adminService.deleteBoardById(id);

        return "redirect:/userboard";
    }

}
