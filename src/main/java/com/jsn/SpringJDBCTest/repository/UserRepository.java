package com.jsn.SpringJDBCTest.repository;

import com.jsn.SpringJDBCTest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(User user) {
        String sqlQuery = "insert into users (id, name, tech) values (?,?,?)";
        int rows = template.update(sqlQuery, user.getId(), user.getName(), user.getTech());
        System.out.println(rows + "row's affected");
    }

    public List<User> findALl() {
        String sqlQuery = "select * from users";

//        RowMapper<User> mapper = (rs, rowNum) -> {
//            User user = new User();
//            user.setId(rs.getInt(1));
//            user.setName(rs.getString(2));
//            user.setTech(rs.getString(3));
//            return user;
//        };
//        List<User> users = template.query(sqlQuery, mapper);
        List<User> users = template.query(sqlQuery, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt(1));
            user.setName(rs.getString(2));
            user.setTech(rs.getString(3));
            return user;
        });
        return users;
    }
}
