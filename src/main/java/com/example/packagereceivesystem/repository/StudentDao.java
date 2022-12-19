package com.example.packagereceivesystem.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.packagereceivesystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
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
    private String INSERT_STUDENT_COMMAND="INSERT INTO staffss(staffss_number, staffss_name_ch, staffss_name_en, staffss_department, staffss_resign) VALUES (?,?,?,?,?)";
    private static final Logger log = LoggerFactory.getLogger(StudentDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void findAllStudent(Student memberAccount){
        try {
            jdbcTemplate.update(GET_ALL_STUDENT_COMMAND);
        }   catch (Exception e){
            log.info(e.toString());
            for (StackTraceElement elem : e.getStackTrace()) {
                log.error(elem.toString());
            }
        }
    }

    public void insert() {
            try{
//                jdbcTemplate.update(INSERT_STUDENT_COMMAND, new PreparedStatementSetter() {
//                    @Override
//                    public void setValues(PreparedStatement ps) throws SQLException {
//                        ps.setString(1,);
//                        ps.setString(2,);
//                        ps.setString(3,map.get("staffss_name_en"));
//                        ps.setString(4,map.get("staffss_department"));
//                    }
//                });
//                log.info("successful insert");
                jdbcTemplate.update("INSERT INTO student(student_id, student_name, student_email, student_department) " +
                        "VALUES (?,?,?,?)",1005,"456","121","12312");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
    }

    public static void main(String[] args) {
        StudentDao studentDao=new StudentDao();
        studentDao.insert();

    }
}
