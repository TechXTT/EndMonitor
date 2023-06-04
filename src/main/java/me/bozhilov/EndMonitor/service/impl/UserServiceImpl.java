package me.bozhilov.EndMonitor.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.bozhilov.EndMonitor.controller.resources.UserResource;
import me.bozhilov.EndMonitor.model.User;
import me.bozhilov.EndMonitor.repository.UserRepository;
import me.bozhilov.EndMonitor.service.CompanyService;
import me.bozhilov.EndMonitor.service.UserService;

import static me.bozhilov.EndMonitor.mapper.UserMapper.userMapper;
import static me.bozhilov.EndMonitor.mapper.CompanyMapper.companyMapper;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CompanyService companyService;

    @Override
    public List<UserResource> findAll() {
        return userMapper.toUserResourceList(userRepository.findAll());
    }

    @Override
    public UserResource findById(Long id) {
        return userMapper.toUserResource(userRepository.findById(id).orElse(null));
    }

    @Override
    public User save(UserResource userResource) {
        User user = userMapper.fromUserResource(userResource);
        companyService.findByName(user.getCompany().getName())
                .ifPresentOrElse(
                        company -> user.setCompany(companyMapper.fromCompanyResource(company)),
                        () -> {
                            throw new EntityNotFoundException(
                                    "Company with name " + user.getCompany().getName() + " not found");
                        });
        return userRepository.save(user);
    }
}
