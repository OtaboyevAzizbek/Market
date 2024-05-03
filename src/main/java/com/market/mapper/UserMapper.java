package com.market.mapper;

import com.market.dto.user.UserDTO;
import com.market.entity.User;
import org.mapstruct.Mapper;

/**
 * @author Азизбек
 * @project Market
 * @date 03.05.2024
 * @time 16:52
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
}