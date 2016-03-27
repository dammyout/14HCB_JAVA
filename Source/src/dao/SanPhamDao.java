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



public class SanPhamDao {
    private SessionFactory sf = null;
    public List<MonAn> finAll(){
        List<MonAn> list = new ArrayList<MonAn>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            list = sf.getCurrentSession().createCriteria(MonAn.class).list();
            
        } catch (Exception e) {
            return null;
        } finally{
            sf.getCurrentSession().close();
            return list;
        }
        
    }
    public MonAn find(String tensanpham){
        MonAn mon_an = new MonAn();
        try {
            sf = HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            mon_an =  (MonAn) sf.getCurrentSession().get(MonAn.class,Integer.parseInt(tensanpham));
        } catch (Exception e) {
            return null;
        }finally{
            HibernateUtil.closeSessionFactory();
            return mon_an;
        }
    }
    public boolean delete(MonAn mon_an){
        try {
            sf = HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(mon_an);
            sf.getCurrentSession().getTransaction().commit();
            
            
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }finally{
            HibernateUtil.closeSessionFactory();
            return true;
        }
    }
    public boolean saveorupdate(MonAn mon_an){
        try {
            sf = HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().saveOrUpdate(mon_an);
            sf.getCurrentSession().getTransaction().commit();
            
            
        } catch (Exception e) {
            return false;
        }finally{
            HibernateUtil.closeSessionFactory();
            return true;
        }
        
        
    }
    public boolean query(MonAn mon_an){
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
