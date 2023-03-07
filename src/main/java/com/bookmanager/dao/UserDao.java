package com.bookmanager.dao;

import com.bookmanager.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

/**
 * 用户Dao层
 *
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/18 23:55
 */
public class UserDao {

    /**
     * 登录验证
     * @param connection    数据库链接
     * @param user  用户
     * @return  查询到的用户
     * @throws Exception    exception
     */
    public User login(Connection connection, User user) throws Exception{
        User resultUser = null;
        String sql = "SELECT * FROM t_user where userName = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            resultUser = new User();
            resultUser.setId(resultSet.getInt("id"));
            resultUser.setUserName(resultSet.getString("userName"));
            resultUser.setPassword(resultSet.getString("password"));
        }
        return resultUser;
    }

    /**
     * 判断用户是否为管理员
     * @param connection    数据库连接
     * @param user  用户对象
     * @return  是否为管理员，若不是则为普通用户
     * @throws Exception    你猜
     */
    public boolean isAdmin(Connection connection, User user) throws Exception{
        boolean result = false;
        String sql = "SELECT * FROM t_user where userName = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            result = resultSet.getBoolean("isAdmin");
            Logger.getGlobal().info(String.valueOf(result));
        }

        return result;

    }

}
