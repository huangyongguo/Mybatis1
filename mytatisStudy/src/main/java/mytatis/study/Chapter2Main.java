package mytatis.study;

import org.apache.ibatis.session.SqlSession;

import mytatis.mapper.RoleMapper;
import mytatis.pojo.Role;
import mytatis.util.SqlSessionFactoryUtil;

public class Chapter2Main 
{
    public static void main( String[] args ){
    SqlSession sqlSession = null;
	try {
		sqlSession = SqlSessionFactoryUtil.openSqlSession();
		RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//		Role role = roleMapper.getRole(101L);
		Role role2 = new Role();
		role2.setNote("我是葫芦娃");
		role2.setRoleName("那身");
		roleMapper.insertRole(role2);
		sqlSession.commit();
//		System.out.println(role.toString());
	} catch (Exception e) {
		System.err.println(e.getMessage());
		sqlSession.rollback();
	} finally {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
    }
}
