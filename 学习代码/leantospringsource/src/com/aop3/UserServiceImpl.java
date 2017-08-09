package com.aop3;

/**
 * Created by walmt on 2017/8/6.
 */
public class UserServiceImpl implements UserService {

    /** (non-Javadoc)
     *  @see com.aop3.UserService#add()
     */
    @Override
    public void add() {
        System.out.println("------------add-------------");
    }
}
