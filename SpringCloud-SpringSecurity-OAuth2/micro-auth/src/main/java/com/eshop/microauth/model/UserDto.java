package com.eshop.microauth.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String id;

    private String username;

    private String password;

    private String fullname;

    private String mobile;

}
