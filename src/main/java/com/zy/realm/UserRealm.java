package com.zy.realm;

import com.zy.entity.User;
import com.zy.mapper.PerMapper;
import com.zy.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PerMapper perMapper;
    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //Set<String> perms = new HashSet<>();
        User principal = (User) principalCollection.getPrimaryPrincipal();
      /*  if("张三儿".equals(principal.getUsername())){
            //给curd权限
            perms.add("emp:add");
            perms.add("emp:update");
            perms.add("emp:del");

        }else if("李四".equals(principal.getUsername())){
            // 查询  增加(emp:add)
            perms.add("emp:add");
        }else if("王五".equals(principal.getUsername())) {
            //查询   修改（emp:update）  删除(emp:del)
            perms.add("emp:update");
            perms.add("emp:del");
        }
*/
        Set<String> perms = this.perMapper.queryPer(principal.getUsername());


        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(perms);

        return simpleAuthorizationInfo;



    }
    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("========================");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //获取用户名
        String username = token.getUsername();
        System.out.println("=========username=====" + username);
        //根据用户名到db查找
        User user = userMapper.getByName(username);
        ByteSource salt = ByteSource.Util.bytes(user.getSalt());

        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(user,user.getPassword(),
        salt,getName());
        System.out.println(getName());
        return simpleAuthenticationInfo;
    }

    public static void main(String[] args) {
        String  hashAlgorithmName="MD5";
        Object credentials="123456";//明文
        UUID uuid = UUID.randomUUID();//产生随机salt编码
        System.out.println(uuid);
        Object salt = ByteSource.Util.bytes(uuid.toString());;

        Object result = new SimpleHash(hashAlgorithmName, credentials,salt,1000);
        System.out.println(result);
    }
}
