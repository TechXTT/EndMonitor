package me.bozhilov.EndMonitor.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import me.bozhilov.EndMonitor.controller.resources.UserResource;
import me.bozhilov.EndMonitor.model.User;

@Mapper
public interface UserMapper {

    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "company.name", source = "userResource.company")
    User fromUserResource(UserResource userResource);

    @Mapping(target = "company", source = "user.company.name")
    UserResource toUserResource(User user);

    List<UserResource> toUserResourceList(List<User> users);
}
