package com.atymtay.spring.course_project.repository;

import com.atymtay.spring.course_project.entities.PermanentCourse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PermanentMapper implements RowMapper<PermanentCourse> {

    @Override
    public PermanentCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println(rowNum);

        PermanentCourse permanentCourse = new PermanentCourse();

        permanentCourse.setId(rs.getLong("id"));
        permanentCourse.setName(rs.getString("name"));
        permanentCourse.setPrice(rs.getInt("price"));
        permanentCourse.setRating(rs.getDouble("rating"));
        permanentCourse.setReleaseDate(rs.getString("releaseDate"));
        return permanentCourse;
    }
}
