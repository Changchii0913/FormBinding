package chang.formbinding.service;

import chang.formbinding.DAO.EventUserDAO;
import chang.formbinding.modelform.UserRegModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserRegistrationService {
@Autowired
    EventUserDAO userDAO;
public int Registration(UserRegModel user){
    // 1:成功 , 2: 帳號已經存在 3: 包含惡意或是禁用字串
    // 收到註冊需求  先檢查帳號是否存在
    // 存在  退申請
    if(user.getUsername().contains("select")||user.getUsername().contains("delete"))
    { return 3;}
    if(isUserExists(user.getUsername())){
        return 2;
    }
    // 不存在  開始檢查資料是否合規
    // 過濾 惡意字詞 可能異常字串(select , inser, update, delete 等)
    // 開始進行 帳號新增作業
    int cnt=userDAO.saveUser(user);
if ( cnt >0){
    return 1;
    }else{
    return cnt;
    }
}
//公用方法
public boolean isUserExists(String username){
    long count= userDAO.isUserExists(username);
    if(count>0){
        return true;
    }else{
        return false;
    }
}
}