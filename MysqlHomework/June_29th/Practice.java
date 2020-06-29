package com.club.banyuan.shengtang.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Practice {
    private static String sql = "select * from user where loginname=? and password=?";
    private static String sql1 = "select * from product where name like ? and description like ?";
    private static String sql2 = "select *,sum(order_detail.quantity),sum(order_detail.cost) " +
            "from product,order_detail where product.id=order_detail.productId " +
            "group by name having name like ?;";
    private static String sql3 = "insert into order(id,loginName,cost) values(null,USER,sum(cost))";
    private static String url = "jdbc:mysql://localhost:3306/shoppingstreet?serverTimezone=UTC";
    private static String USER = "root";
    private static String PASSWORD = "root";
    private static Map<Product, Integer> map;

    static {
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String user = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        try {
            login(user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("请输入要查询的商品:");
        String goodsName = scanner.nextLine();
        try {
            search(goodsName);
            insert(USER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void login(String user, String password) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, USER, PASSWORD);
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user);
        ps.setString(2, password);
        ResultSet resultSet = ps.executeQuery();

        resultSet.close();
        ps.close();
        connection.close();
    }

    public static void search(String goodsName) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
        preparedStatement.setString(1, "%" + goodsName + "%");
        preparedStatement.setString(2, "%" + goodsName + "%");
        preparedStatement1.setString(1, "%" + goodsName + "%");
        ResultSet resultSet1 = preparedStatement.executeQuery();
        ResultSet resultSet2 = preparedStatement1.executeQuery();
        while (resultSet1.next()) {
            Product p = new Product();
            int id = resultSet1.getInt(1);
            String name = resultSet1.getString(2);
            String desc = resultSet2.getString(3);
            p.setId(id);
            p.setName(name);
            p.setDescription(desc);

            int count = resultSet1.getInt(4);
            map.put(p, count);

            //订单是两个华为商品
            //order表插入一个记录记录aaa购买的信息
            //order_detail表插入一条详情信息
        }
    }

    public static void insert(String user) throws SQLException {
        Connection connection = DriverManager.getConnection(url, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql3);
        int result = preparedStatement.executeUpdate();
        if (result > 0) {
            System.out.println("success");
        } else {
            System.out.println("faile");
        }

    }

}
