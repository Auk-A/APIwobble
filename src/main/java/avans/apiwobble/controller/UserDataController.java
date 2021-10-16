package avans.apiwobble.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserDataController {

    @RequestMapping("")
    @ResponseBody
    public String getUserData(HttpServletRequest request){

        String userId = request.getParameter("userid");
        return "Return JSON with user data for user "+ userId + ".";
    }

    @RequestMapping("wallet")
    @ResponseBody
    public String getWalletData(HttpServletRequest request){

        String userId = request.getParameter("userid");
        return "Return JSON with wallet data for user " + userId + ".";
    }

}
