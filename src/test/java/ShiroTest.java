import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class ShiroTest {
    @Test
    public void testHelloworld() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("jay", "123456");
        try {
            //4、登录，即身份验证
            subject.login(token);
            System.out.println("登录成功");
        } catch (AuthenticationException e) {
            //5、身份验证失败
            System.out.println("账号或密码错误");
        }
        //Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        if (subject.isAuthenticated()){
            System.out.println("已经登录");
        }else{
            System.out.println("未登录");
        }
        //判断该用户是否是指定的角色
        System.out.println(subject.hasRole("role2"));
        System.out.println(subject.hasRole("role3"));
        //判断该用户是否拥有指定的权限
        System.out.println(subject.isPermitted("user:query"));
        //6、退出
        subject.logout();
    }
}

