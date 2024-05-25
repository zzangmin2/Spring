package daelim.spring.survey;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Repository
public class SurveyDao {
    private JdbcTemplate jdbcTemplate;

    public SurveyDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert(final Survey survey) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(
                        "INSERT INTO SURVEY(Q1, Q2, Q3, RespondentName, RespondentAge, REGDATE) VALUES (?,?,?,?,?,?)",
                        new String[]{"ID"});
                preparedStatement.setString(1, survey.getQ1());
                preparedStatement.setString(2, survey.getQ2());
                preparedStatement.setString(3, survey.getQ3());
                preparedStatement.setString(4, survey.getRespondentName());
                preparedStatement.setInt(5, survey.getRespondentAge());
                preparedStatement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
                return preparedStatement;
            }
        }, keyHolder);
        Number keyValue = keyHolder.getKey();

    }


    public List<Survey> selectAll() {
        String sql = "SELECT * FROM SURVEY";
        return jdbcTemplate.query(sql, new RowMapper<Survey>() {
            @Override
            public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Survey(
                        rs.getInt("ID"),
                        rs.getString("Q1"),
                        rs.getString("Q2"),
                        rs.getString("Q3"),
                        rs.getString("RespondentName"),
                        rs.getInt("RespondentAge"),
                        rs.getTimestamp("REGDATE")
                );
            }
        });
    }




}
