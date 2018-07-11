package test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.joyo.dao.HistoricalRecordsDao;

import com.joyo.pojo.HistoricalRecords;
import test.FKSqlSessionFactory;

public class HistoryTest {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			// 读取mybatis-config.xml文件
					SqlSession session = FKSqlSessionFactory.getSqlSession();
					
					HistoryTest t = new HistoryTest();
					
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
					HistoricalRecordsDao hd = session.getMapper(HistoricalRecordsDao.class);
					// 调用selectOrderById方法
					/**
				//	 Area selectByPrimaryKey(Integer areaid);
					//HistoricalRecords selectByPrimaryKey(HistoricalRecords recordid);
					HistoricalRecords hr =hd.selectById(2);
					
					// 查看查询到的order对象信息
		
					System.out.println("设备号: " + " 水位: " + hr.getMeternumber()
					+" 地区: " + " 地区数量: " + hr.getAreanumber() 
					+ " 实时流量: " + hr.getInstantaneousflow() + " 累计流量: " + hr.getCumulativeflow()+ " 负流量: "+
					hr.getPositivecumulativeflow() + " 水温: " + hr.getWatersupplytemperature()+" " +
					" 状态: " + hr.getState() + " 时间: " + hr.getTime()
							);
					
				**/
					HistoricalRecords hr = hd.selectById(2);
				
					
				
					
					
					
					
			}
}


