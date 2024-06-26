package chang.formbinding.DAO;

import chang.formbinding.modelform.UserRegModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//跟資料庫溝通的地方
@Repository
public class EventUserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int saveUser(UserRegModel user){
    String sql="INSERT INTO user(username,email,mobile,passwd) VALUES(?,?,?,?)";
            return jdbcTemplate.update(sql,user.getUsername(),user.getEmail(),user.getMobile(),user.getPasswd());
    }
    public long isUserExists(String username) {
        String sql = "SELECT COUNT(*) FROM USER WHERE username=?";
        // select count(*) 回傳一慮使用 long 型別
        return jdbcTemplate.queryForObject(sql,Long.class, username);

    }

}
