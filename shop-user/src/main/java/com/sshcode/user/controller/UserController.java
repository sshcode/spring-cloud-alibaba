package com.sshcode.user.controller;

import com.sshcode.model.UserVO;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    /**
     *
     * @param userVO
     * @return
     * @throws RuntimeException
     */
    public UserVO queryUser(UserVO userVO)throws RuntimeException{
        UserVO userVO1 = new UserVO();
        return userVO1;
    }

    /**
     * 
     * @param userVO
     * @return
     * @throws RuntimeException
     */
    public Integer inserUser(UserVO userVO)throws RuntimeException{

        return 1;
    }
}
