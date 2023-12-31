package team7.example.ToyProject3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team7.example.ToyProject3.domain.user.User;
import team7.example.ToyProject3.domain.user.UserRole;
import team7.example.ToyProject3.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Scheduler {

	private final UserRepository userRepository;

	@Transactional
	@Scheduled(fixedDelay = 60000)
	public void changeUserRole() {

		List<User> newbiesWithTenOrMoreBoards = userRepository.findByUserRoleAndBoardCount(UserRole.NORMAL, 10);

		for (User user : newbiesWithTenOrMoreBoards) {
			user.setUserRole(UserRole.VIP);
		}

		userRepository.saveAll(newbiesWithTenOrMoreBoards);
	}
}
