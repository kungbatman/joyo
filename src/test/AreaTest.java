package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.joyo.dao.AreaDao;
import com.joyo.pojo.Area;

import test.FKSqlSessionFactory;


public class AreaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 读取mybatis-config.xml文件
				SqlSession session = FKSqlSessionFactory.getSqlSession();
				
				AreaTest t = new AreaTest();
				
				// 根据用户id查询用户，测试一对多
				//t.testSelectUserById(session);
				// 根据订单id查询订单，测试多对多
				t.testSelectOrderById(session);
				
				// 提交事务
				session.commit();
				// 关闭Session
				session.close();
			}
			
			// 测试一对多，查询班级User（一）的时候级联查询订单Order（多）  
			/*
			public void testSelectUserById(SqlSession session){
				// 获得UserMapper接口的代理对象
				UserMapper um = session.getMapper(UserMapper.class);
				// 调用selectUserById方法
				User user = um.selectUserById(1);
				// 查看查询到的user对象信息
				System.out.println(user.getId() + " " + user.getUsername());
				// 查看user对象关联的订单信息
				List<Order> orders = user.getOrders();
				for(Order order : orders){
					System.out.println(order);
				}
			}
			*/
			
			// 测试多对多，查询订单Order（多）的时候级联查询订单的商品Article（多）  
			public void testSelectOrderById(SqlSession session){
				// 获得OrderMapper接口的代理对象
				AreaDao ad = session.getMapper(AreaDao.class);
				// 调用selectOrderById方法
				
			//	 Area selectByPrimaryKey(Integer areaid);
			//	Area area = ad.selectById(1);
				// 查看查询到的order对象信息
				
				// 查看order对象关联的用户信息
			/*
				User user = order.getUser();
				System.out.println(user);
				// 查看order对象关联的商品信息
				List<Article> articles = order.getArticles();
				for(Article article : articles){
					System.out.println(article);
				}
				*/
			//	Area area = ad.selectById(2);
			List<Area> areas =  ad.selectAllArea();
	//	ad.selectAllArea();
				//ad.deleteById(3);
			for(Area area:areas) {
			//System.out.println(area);
			
				
				 System.out.println(area.getAddressnumber() + " " +   area.getAreaname()
					+" " +  area.getArealevel() + " " +  area.getHigherareanumber() + " " 
					+  area.getHigherareaname() + " " +area.getValidtags()
							);
							
			}	
			}
	}


