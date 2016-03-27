/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.*;
import entity.*;
import org.hibernate.*;
import util.HibernateUtil;



/**
 *
 * @author My PC
 */
public class UserDao {
    private SessionFactory sf = null;
    public List<User> finAll(){ 
        List<User> list = new ArrayList<User>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            list = sf.getCurrentSession().createCriteria(User.class).list();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally{
           sf.getCurrentSession().close();
            return list;
        }
        
    }
    public boolean CheckUser (String tk,String mk){ 
      
         for (User user :this.finAll()){
             System.out.print(user.getUsername());
            if(tk.equals(user.getUsername())&&  mk.equals(user.getPass())){
                System.out.print("Dang nhap thanh công; "); 
               return true;
            }
            else{
            System.out.print("Dang nhap that bai; ");
            
            }
        }
        return false;
    } 
    
    public User find(String ten_nhan_vien){
        User nhan_vien = new User();
        try {
            sf = HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            nhan_vien=  (User) sf.getCurrentSession().get(User.class,Integer.parseInt(ten_nhan_vien));
        } catch (Exception e) {
            return null;
        }finally{
            HibernateUtil.closeSessionFactory();
            return nhan_vien;
        }
    }
    public boolean delete(User nhan_vien){
        try {
            sf = HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(nhan_vien);
            sf.getCurrentSession().getTransaction().commit();
            
            
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }finally{
            HibernateUtil.closeSessionFactory();
            return true;
        }
    }
    public boolean saveorupdate(User nhan_vien){
        try {
            sf = HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().saveOrUpdate(nhan_vien);
            sf.getCurrentSession().getTransaction().commit();
            
            
        } catch (Exception e) {
            return false;
        }finally{
            HibernateUtil.closeSessionFactory();
            return true;
        }
        
        
    }
    public boolean query(User nhan_vien){
        try {
            sf= HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().createQuery(null);
            
        } catch (Exception e) {
            return false;
        }finally{
             HibernateUtil.closeSessionFactory();
             return true;
        }
     
    }

    public Object danhsach() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean saveorupdate(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
