package chang.formbinding.controller;

import chang.formbinding.modelform.UserRegModel;
import chang.formbinding.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserRegistrationService userRegistrationService;
    @GetMapping("/regform")
    public String UserReg(Model model){
        // 使用者送 request 進來後 回傳 註冊表單名稱
        // 準備好一個空的 UserRegModel 物件 提供表單與 UserRegModel 綁定
        UserRegModel userModel= new UserRegModel();
        model.addAttribute("usermodel",userModel);
        return "user-regform";
    }
    @PostMapping("/regform")
    public String UserRegProcess(@RequestParam("username") String username,
                                 @RequestParam("email") String email,
                                 @RequestParam("mobile") String mobile,
                                 Model model){
        // 使用者送 request 進來後 回傳 註冊表單名稱
        model.addAttribute("user",username);
        model.addAttribute(email);
        model.addAttribute(mobile);
        return "reg-result";
    }
    @PostMapping("/regform2")
    public String UserRegProcess2(@ModelAttribute UserRegModel usermodel, Model model){
        // 使用者送 request 進來後 回傳 註冊表單名稱

        //Spring从请求中获取与 UserRegModel 类相对应的参数，并将其绑定到 usermodel 对象中

        String msg=null;
        int result= userRegistrationService.Registration(usermodel);
        switch (result){
            case 0:
                msg="新增失敗";
            break;
            case 1:
                msg="成功註冊";
            break;
            case 2:
                msg="註冊過了";
            break;
            case 3:
                msg="不可包含關鍵字";
            break;
            default:
                msg="其他原因";
                break;

        }
        //結過通知
        model.addAttribute("user",usermodel.getUsername());
        model.addAttribute("email",msg);
        return "reg-result";

    }
}
