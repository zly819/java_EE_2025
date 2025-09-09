package Test;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class UserTest {


    //1、增加用户测试
    @Test
    public void userAddTest() {
        String resources = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlMapper.openSession();
        User user = new User();
        user.setUsername("wang11");
        user.setPassword("666611");
        user.setEmail("wang@163.com");
        int result = session.insert("com.itheima.mapper.UserMapper.insertUser", user);
        //输出插入的整条数据
        System.out.println("新增数据为\n" + user.getId() + "\n" + user.getUsername() + "\n" + user.getPassword() + "\n" + user.getEmail());
        session.commit();
        session.close();
    }

    //2、删除用户测试
    @Test
    public void userDeleteTest() {
        String resources = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlMapper.openSession();
        int result = session.delete("com.itheima.mapper.UserMapper.deleteUserById", 9);
        System.out.println("删除数据条数为：" + result);
        session.commit();
        session.close();
    }
    //3、修改用户测试
    @Test
    public void userUpdateTest() {
        String resources = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlMapper.openSession();
        //根据id获取修改的数据
        User user = session.selectOne("com.itheima.mapper.UserMapper.selectUserById", 10);
        user.setId(10);
        user.setUsername("小王");
        int result = session.update("com.itheima.mapper.UserMapper.updateUser", user);
        //修改后的数据
        System.out.println("修改数据为：" + user.getId() + "\n" + user.getUsername() + "\n" + user.getPassword() + "\n" + user.getEmail());
        session.commit();
        session.close();
    }

    //4、查询单个用户，根据ID查询
    @Test
    public void userFindByIdTest() {
        String resources = "mybatis-config.xml";
        //创建流
        Reader reader = null;
        try {
            //读取 mybatis-config.xml 文件内容到 reader 对象中
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化 MyBatis 数据库，创建 SqlSessionFactory 类的实例
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

        //创建 SqlSession 实例
        SqlSession session = sqlMapper.openSession();
        //传入参数查询，返回结果
        User user = session.selectOne("com.itheima.mapper.UserMapper.selectUserById", 10);
        //输出结果
        System.out.println(user.getUsername());
        //关闭 session
        session.close();
    }

    //5、查询所有用户
    @Test
    public void userFindAllTest() {
        String resources = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlMapper.openSession();
        List<User> users = session.selectList("com.itheima.mapper.UserMapper.selectAllUsers");
        for (User user : users) {
            System.out.println(user.getId() + "\n" + user.getUsername() + "\n" + user.getPassword() + "\n" + user.getEmail());
        }
        session.close();
        System.out.println("查询数据条数为：" + users.size());
    }
}