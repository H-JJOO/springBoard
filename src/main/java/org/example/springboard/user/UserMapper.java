package org.example.springboard.user;

import org.apache.ibatis.annotations.Mapper;
import org.example.springboard.user.model.UserEntity;

@Mapper
public interface UserMapper {
    int insUser(UserEntity entity);
    UserEntity selUser(UserEntity entity);
}
