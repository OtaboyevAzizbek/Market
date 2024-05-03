package com.market.dto.user;

import com.market.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO {
    String username;
    String password;
    Role role;
}
