package com.hoangbuix.bicycle.model.mapper;

import com.hoangbuix.bicycle.entity.RoleEntity;
import com.hoangbuix.bicycle.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class UserMapper implements RowMapper<UserEntity> {
    @Override
    public UserEntity mapRow(ResultSet resultSet) {
        try {
            UserEntity user = new UserEntity();
            user.setId(resultSet.getInt("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setAvatar(resultSet.getString("avatar"));
            user.setUsername(resultSet.getString("user_name"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setActiveFlag(resultSet.getInt("active_flag"));
            user.setCreatedDate(resultSet.getDate("created_date"));
            user.setUpdatedDate(resultSet.getDate("updated_date"));
            try {
                RoleEntity role = new RoleEntity();
                if (resultSet.getString("role_name") != null || resultSet.getString("role_name") != "") {
                    role.setRoleName(resultSet.getString("role_name"));
                    user.setRoles(Collections.singleton(role));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
