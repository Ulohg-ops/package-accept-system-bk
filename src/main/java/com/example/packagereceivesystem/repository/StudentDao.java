package com.example.packagereceivesystem.repository;

import com.example.packagereceivesystem.model.PersonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.packagereceivesystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Component
public class StudentDao {
    private int student_id;
    private String  student_name;
    private String  student_email;
    private String  student_department;
    private String GET_ALL_STUDENT_COMMAND="SELECT * FROM Student";
    private String INSERT_STUDENT_COMMAND="INSERT INTO student(student_id, student_name, student_email, student_department) VALUES (?,?,?,?)";
    private static final Logger log = LoggerFactory.getLogger(StudentDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> findAllStudent(){
        return jdbcTemplate.query(GET_ALL_STUDENT_COMMAND, new PersonMapper());
    }

    public void saveStudent(Student student) {
            try{
                jdbcTemplate.update(INSERT_STUDENT_COMMAND, new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setInt(1,Integer.parseInt(student.getId().toString()));
                        ps.setString(2,student.getName());
                        ps.setString(3,student.getEmail());
                        ps.setString(4,student.getDepartment());
                    }
                });
                log.info("successful insert");
//                jdbcTemplate.update("INSERT INTO student(student_id, student_name, student_email, student_department) " +
//                        "VALUES (?,?,?,?)",1005,"456","121","12312");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
    }
}
