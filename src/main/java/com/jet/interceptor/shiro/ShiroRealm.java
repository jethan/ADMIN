package com.jet.interceptor.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;


/**
 * @author jet
 *  2015-3-6
 */
public class ShiroRealm extends AuthorizingRealm {

	/*
	 * 登录信息和用户验证信息验证(non-Javadoc)验证当前登录的Subject
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

		 String username = (String)authcToken.getPrincipal();  				//得到用户名
	     String password = new String((char[])authcToken.getCredentials()); 	//得到密码
		
	     if(null != username && null != password){
	         this.setSession("currentUser", username);
	    	 return new SimpleAuthenticationInfo(username, password, getName());
	     }else{
	         //没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
	    	 return null;
	     }
    }
	
	/*
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        //获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
        String currentUsername = (String)super.getAvailablePrincipal(pc);
        //      List<String> roleList = new ArrayList<String>();
        //      List<String> permissionList = new ArrayList<String>();
        //      //从数据库中获取当前登录用户的详细信息
        //      User user = userService.getByUsername(currentUsername);
        //      if(null != user){
        //          //实体类User中包含有用户角色的实体类信息
        //          if(null!=user.getRoles() && user.getRoles().size()>0){
        //              //获取当前登录用户的角色
        //              for(Role role : user.getRoles()){
        //                  roleList.add(role.getName());
        //                  //实体类Role中包含有角色权限的实体类信息
        //                  if(null!=role.getPermissions() && role.getPermissions().size()>0){
        //                      //获取权限
        //                      for(Permission pmss : role.getPermissions()){
        //                          if(!StringUtils.isEmpty(pmss.getPermission())){
        //                              permissionList.add(pmss.getPermission());
        //                          }
        //                      }
        //                  }
        //              }
        //          }
        //      }else{
        //          throw new AuthorizationException();
        //      }
        //      //为当前用户设置角色和权限
        //      SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        //      simpleAuthorInfo.addRoles(roleList);
        //      simpleAuthorInfo.addStringPermissions(permissionList);
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        //实际中可能会像上面注释的那样从数据库取得
        if(null!=currentUsername && "jadyer".equals(currentUsername)){
            //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
            simpleAuthorInfo.addRole("admin");
            //添加权限
            simpleAuthorInfo.addStringPermission("admin:manage");
            System.out.println("已为用户[jadyer]赋予了[admin]角色和[admin:manage]权限");
            return simpleAuthorInfo;
        }else if(null!=currentUsername && "玄玉".equals(currentUsername)){
            System.out.println("当前用户[玄玉]无授权");
            return simpleAuthorInfo;
        }
        //若该方法什么都不做直接返回null的话,就会导致任何用户访问/admin/listUser.jsp时都会自动跳转到unauthorizedUrl指定的地址
        //详见applicationContext.xml中的<bean id="shiroFilter">的配置
        return null;
    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     */
    private void setSession(Object key, Object value){
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser){
            Session session = currentUser.getSession();
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if(null != session){
                session.setAttribute(key, value);
            }
        }
    }

}
