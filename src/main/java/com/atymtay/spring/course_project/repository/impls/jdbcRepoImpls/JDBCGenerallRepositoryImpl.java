package com.atymtay.spring.course_project.repository.impls.jdbcRepoImpls;

import com.atymtay.spring.course_project.entities.LiveCourse;
import com.atymtay.spring.course_project.repository.GenerallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JDBCGenerallRepositoryImpl implements GenerallRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCGenerallRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LiveCourse> getAll() {
        return jdbcTemplate.query("select * from livecourse",
                (rs, rowNum) ->
                    new LiveCourse(

                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getInt("price"),
                            rs.getDouble("rating"),
                            rs.getString("startDate"),
                            rs.getString("endDate")
                    ));
    }

    @Override
    public Optional<LiveCourse> getById(Long id) {
        return jdbcTemplate.queryForObject("select * from livecourse where id = ?",
                (rs, rowNum) -> Optional.of(
                        new LiveCourse(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getInt("price"),
                                rs.getDouble("rating"),
                                rs.getString("startDate"),
                                rs.getString("endDate")
                        )
                ),
                id);
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from livecourse where id = ?", id);
    }

    @Override
    public Optional<LiveCourse> getByName(String name) {
        return jdbcTemplate.queryForObject("select * from livecourse where name = ?",
                (rs, rowNum) -> Optional.of(
                        new LiveCourse(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getInt("price"),
                                rs.getDouble("rating"),
                                rs.getString("startDate"),
                                rs.getString("endDate")
                        )
                ),
                name);
    }



    @Override
    public void save(Object object) {
        LiveCourse new_liveCourse = (LiveCourse) object;
        jdbcTemplate.update("insert into livecourse (name,price,rating,startDate,endDate) values(?,?,?,?,?)",
                new_liveCourse.getName(),new_liveCourse.getPrice(),
                new_liveCourse.getRating(),
                new_liveCourse.getStartDate(),new_liveCourse.getEndDate());

    }

    @Override
    public void update(Object object) {
        LiveCourse new_liveCourse = (LiveCourse) object;
        jdbcTemplate.update("update livecourse set name = ? where price > 5000",
                new_liveCourse.getName());
    }
}
