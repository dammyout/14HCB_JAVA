/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.BanAn;
import entity.BanAn;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Tamkhung
 */
public class QuanlybanDao {
    private SessionFactory sf = null;
    public List<BanAn> finAll(){ 
        List<BanAn> list = new ArrayList<BanAn>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            list = sf.getCurrentSession().createCriteria(BanAn.class).list();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally{
           sf.getCurrentSession().close();
            return list;
        }
        
    }
    // List <BanAn> listban=new BanAn()
    public List<BanAn> CheckBanAn (){ 
    
      
      List<BanAn> list = new ArrayList<>();
         for (BanAn banan :this.finAll()){
             //System.out.print(banan.getTinhtrang());
            if(banan.getTinhtrang().equals("con")){
                System.out.print(" con "); 
               list.add(banan);
            }
            else{
            System.out.print(" het ");
            }
        }
        return list;
    } 

    
    public BanAn find(String ten_ba_nan){
        BanAn ba_nan = new BanAn();
        try {
            sf = HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            ba_nan=  (BanAn) sf.getCurrentSession().get(BanAn.class,Integer.parseInt(ten_ba_nan));
        } catch (Exception e) {
            return null;
        }finally{
            HibernateUtil.closeSessionFactory();
            return ba_nan;
        }
    }
    public boolean delete(BanAn ba_nan){
        try {
            sf = HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(ba_nan);
            sf.getCurrentSession().getTransaction().commit();
            
            
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }finally{
            HibernateUtil.closeSessionFactory();
            return true;
        }
    }
    public boolean saveorupdate(BanAn ba_nan){
        try {
            sf = HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().saveOrUpdate(ba_nan);
            sf.getCurrentSession().getTransaction().commit();
            
            
        } catch (Exception e) {
            return false;
        }finally{
            HibernateUtil.closeSessionFactory();
            return true;
        }
   
    }
    public boolean query(BanAn ba_nan){
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
