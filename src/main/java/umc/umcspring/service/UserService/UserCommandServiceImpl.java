package umc.umcspring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umcspring.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;

    @Override
    public boolean isUserExists(Integer userId) {

        return userRepository.findById(userId).isPresent();

    }
}
