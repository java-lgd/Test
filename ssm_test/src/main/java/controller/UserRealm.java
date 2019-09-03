package controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserRealm extends AuthorizingRealm
{
    protected Logger logger =  LoggerFactory.getLogger(this.getClass());  
    @Override
    protected AuthorizationInfo  doGetAuthorizationInfo(PrincipalCollection arg0)
    {
        UsernamePasswordToken token =  (UsernamePasswordToken)  SecurityUtils.getSubject().getPrincipal();
        String username = token.getUsername();
        logger.info(username + "��Ȩ...");
        // �����ݿ��в��Ҹ��û��Ľ�ɫ��Ȩ��
        SimpleAuthorizationInfo sainfo = new  SimpleAuthorizationInfo();
        Set<String> roles = new  HashSet<String>();
        roles.add("admin");
        //roles.add("role1");
        Set<String> permissions = new  HashSet<String>();
        permissions.add("add");
        permissions.add("delete");
        sainfo.setRoles(roles);
         sainfo.setStringPermissions(permissions);
        return sainfo;
    }
    @Override
    protected AuthenticationInfo  doGetAuthenticationInfo(AuthenticationToken  arg0)
        throws AuthenticationException
    {
    UsernamePasswordToken token =  (UsernamePasswordToken) arg0;
        String username = token.getUsername();
        // ����username�����ݿ�����û����õ�����
        // �����ҵ����û�����
        // User user =  userService.findByUsername(username)
//        if (null == user)
//        {
//            throw new  AccountException("username is not exist");
//        }
//        else if  (!user.getPassword().equals(new  String(token.getPassword())))
//        {
//            throw new  AccountException("password is not right");
//        }
//        else
//        {
            // ��½�ɹ�
            logger.info("{} login success.",  username);
//        }
        return new  SimpleAuthenticationInfo(arg0,  "21232f297a57a5a743894a0e4a801fc3", username);
    }
}