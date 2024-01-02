package chang.formbinding.DAO;

import chang.formbinding.modelform.UserRegModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EventUserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int saveUser(UserRegModel user){
    String sql="INSERT INTO user(username,email,mobile,passwd) VALUES(?,?,?,?)";
            return jdbcTemplate.update(sql,user.getUsername(),user.getEmail(),user.getMobile(),user.getPasswd());
    }

}
