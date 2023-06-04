package me.bozhilov.EndMonitor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.bozhilov.EndMonitor.controller.resources.UserResource;
import me.bozhilov.EndMonitor.model.User;
import me.bozhilov.EndMonitor.repository.UserRepository;
import me.bozhilov.EndMonitor.service.CompanyService;
import me.bozhilov.EndMonitor.service.UserService;

import static me.bozhilov.EndMonitor.mapper.UserMapper.userMapper;
import static me.bozhilov.EndMonitor.mapper.CompanyMapper.COMPANY_MAPPER;

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
    public Optional<UserResource> findById(Long id) {
        return Optional.ofNullable(userMapper.toUserResource(userRepository.findById(id).orElse(null)));
    }

    @Override
    public User save(UserResource userResource) {
        User user = userMapper.fromUserResource(userResource);
        companyService.findByName(user.getCompany().getName())
                .ifPresentOrElse(
                        company -> user.setCompany(COMPANY_MAPPER.fromCompanyResource(company)),
                        () -> {
                            throw new EntityNotFoundException(
                                    "Company with name " + user.getCompany().getName() + " not found");
                        });
        return userRepository.save(user);
    }

    @Override
    public User update(UserResource userResource, Long id) {
        User user = userMapper.fromUserResource(userResource);
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
