package com.atymtay.spring.course_project.repository.impls.jdbcRepoImpls;

import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.repository.GenerallRepository;
import com.atymtay.spring.course_project.repository.PermanentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JDBCPermanentGenerallRepositoryImpl implements GenerallRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCPermanentGenerallRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<PermanentCourse> getAll() {
        return jdbcTemplate.query("select * from permanentcourse",
                new PermanentMapper());
    }

    @Override
    public Optional<PermanentCourse> getById(Long id) {

        Map<String, Long> parameters = new HashMap<>();
        parameters.put("id", id);

        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from permanentcourse where id= :id",
                        parameters, new PermanentMapper()));
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from permanentcourse where id = :id",
                new MapSqlParameterSource("id", id));
    }

    @Override
    public Optional<PermanentCourse> getByName(String name) {
        return Optional.ofNullable(Optional.of(Objects.requireNonNull(jdbcTemplate.queryForObject("select * from permanentcourse where name= :name",
                        new MapSqlParameterSource("name", name),
                        new PermanentMapper())))
                .orElseThrow(NullPointerException::new));
    }

    @Override
    public void save(Object object) {
        String sql = "insert into permanentcourse (name,price,rating,releaseDate) " +
                "values (:name, :price, :rating, :releaseDate)";

        jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(object));

    }

    @Override
    public void update(Object object) {
        PermanentCourse newPermCourse = (PermanentCourse) object;
        jdbcTemplate.update("update permanentcourse set name = :name where price > 5000"
                , new MapSqlParameterSource()
                        .addValue("name", newPermCourse.getName()));
    }
}
