package com.huihuang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.huihuang.dao.UserDao;
import com.huihuang.javabean.User;
import com.huihuang.util.DButil;
import com.huihuang.util.DateUtil;

public class UserDaoImpl implements UserDao{
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;

	public UserDaoImpl() {
		this.conn=new DButil().dbOpen();
	}

	@Override//增加用户
	public boolean addUser(User user) {
		boolean flag=false;
		String sql="insert into user(userName,passWord,name,sex,userType) values(?,?,?,?,?)";
		try {
			this.conn.setAutoCommit(false);
			this.pstm=this.conn.prepareStatement(sql);
			this.pstm.setString(1, user.getUserName());
			this.pstm.setString(2, user.getPassword());
			this.pstm.setString(3, user.getName());
			this.pstm.setString(4, user.getSex());
			this.pstm.setString(5, user.getUserType());
			int i=this.pstm.executeUpdate();
			this.conn.commit();
			if(i>0){
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("****增加失败****");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("****增加已回滚****");
				flag=false;
			}
		}finally{
			DButil.dbClose(this.conn, this.pstm,this.rs);
			System.out.println("****用户已添加****");
		}
		return flag;
	}


	@Override//删除用户
	public boolean delUser(Integer delId) {
		boolean flag=false;
		String sql="delete from user where id=?";
		try {
			this.conn.setAutoCommit(false);
			this.pstm=this.conn.prepareStatement(sql);
			this.pstm.setInt(1, delId);
			int i=this.pstm.executeUpdate();
			this.conn.commit();
			if(i>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag=false;
			System.out.println("****用户删除失败****");
			try {
				this.conn.rollback();
				System.out.println("****删除已回滚****");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DButil.dbClose(this.conn, this.pstm);
			System.out.println("****用户已删除****");
		}
		return flag;
	}

	@Override//更改用户信息
	public boolean upUser(Integer no,User user) {
		boolean flag=false;
		String sql=null;
		try {
			this.conn.setAutoCommit(false);
			switch(no){
			case 0:
				sql="update user set name = ? , sex = ? , userType = ? , passWord= ? where id= ?";
				this.pstm=this.conn.prepareStatement(sql);
				this.pstm.setString(1, user.getName());
				this.pstm.setString(2, user.getSex());
				this.pstm.setString(3, user.getUserType());
				this.pstm.setString(4, user.getPassword());
				this.pstm.setInt(5, user.getId());
				break;
			case 1:
				sql="update user set lastTime=? where id=?";
				String lastTime=new DateUtil().getdate();//获取工具类时间
				this.pstm=this.conn.prepareStatement(sql);
				this.pstm.setString(1, lastTime);
				this.pstm.setInt(2, user.getId());
				break;
			}
			int i=this.pstm.executeUpdate();
			this.conn.commit();
			flag=i>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("****用户更新失败****");
			try {
				this.conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("****更新已回滚****");
			}
			flag=false;
		}finally{
			DButil.dbClose(this.conn, this.pstm);
			System.out.println("****用户已更新****");
		}
		return flag;
	}

	
	@Override//所有查询操作都在这里
	public List<User> selectUser(Integer no, User user) {
		List<User> lu=new ArrayList<User>();
		String sql="select * from user";//这里空格
		switch(no){
		case 0:
			sql+=" where 1=1";//不好意思的占个位置，没有别的意义
			break;
		case 1:
			sql+=" where userName=?";//判断用户存在操作语句
			break;
		case 2:
			sql+=" where userName=?and passWord=?";//登录语句
			break;
		case 3:
			sql+=" where id=?";//通过id查询
			break;
		}
		try {
			this.pstm=this.conn.prepareStatement(sql);
			switch(no){
			case 0:
				break;
			case 1:
				this.pstm.setString(1, user.getUserName());
				break;
			case 2:
				this.pstm.setString(1, user.getUserName());
				this.pstm.setString(2, user.getPassword());
				break;
			case 3:
				this.pstm.setInt(1, user.getId());
				break;
			}
			this.rs=pstm.executeQuery();
			while(rs.next()){
				User u=new User(
						rs.getInt("id"), 
						rs.getString("userName"),
						rs.getString("name"),
						rs.getString("passWord"),
						rs.getString("sex"),
						rs.getString("userType"),
						rs.getString("lastTime"),
						rs.getInt("userID"));
				lu.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.dbClose(this.conn, this.pstm,this.rs);
			System.out.println("****查询数据****");
		}
		return lu;
	}

}
