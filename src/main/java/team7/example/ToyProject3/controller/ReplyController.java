package team7.example.ToyProject3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team7.example.ToyProject3.domain.user.UserAdaptor;
import team7.example.ToyProject3.dto.reply.ReplyRequestDto;
import team7.example.ToyProject3.service.impl.ReplyServiceImpl;

@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
public class ReplyController {

	private final ReplyServiceImpl replyServiceimpl;

	@PostMapping("/{boardId}/reply")
	public String addReply(ReplyRequestDto.ReplyDto saveReplyDto,
		@AuthenticationPrincipal UserAdaptor userAdaptor) {
		replyServiceimpl.addReply(saveReplyDto, userAdaptor.getUser());
		return "redirect:/board/{boardId}";
	}

	@GetMapping("/{boardId}/reply/{replyId}")
	public String deleteReply(@PathVariable Long boardId, @PathVariable Long replyId,
		@AuthenticationPrincipal UserAdaptor userAdaptor) {
		replyServiceimpl.deleteReply(replyId, boardId, userAdaptor.getUser());
		return "redirect:/board/{boardId}";
	}

	@PostMapping("/{boardId}/reply/{parentReplyId}")
	public String addNestedReply(
		ReplyRequestDto.NestedReplyDto saveNestedReplyDto,
		@AuthenticationPrincipal UserAdaptor userAdaptor) {
		replyServiceimpl.addNestedReply(saveNestedReplyDto, userAdaptor.getUser());
		return "redirect:/board/{boardId}";
	}

	@GetMapping("/{boardId}/nestedReply/{replyId}")
	public String deleteNestedReply(
		@PathVariable Long boardId, @PathVariable Long replyId,
		@AuthenticationPrincipal UserAdaptor userAdaptor) {
		replyServiceimpl.deleteNestedReply(boardId, replyId, userAdaptor.getUser());
		return "redirect:/board/{boardId}";
	}
}
