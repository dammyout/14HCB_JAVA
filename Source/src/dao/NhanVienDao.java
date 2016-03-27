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
public class NhanVienDao {
    private SessionFactory sf = null;
    public List<Nhanvien> finAll(){
        List<Nhanvien> list = new ArrayList<Nhanvien>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            list = sf.getCurrentSession().createCriteria(Nhanvien.class).list();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally{
           sf.getCurrentSession().close();
            return list;
        }
        
    }
    public Nhanvien find(String ten_nhan_vien){
        Nhanvien nhan_vien = new Nhanvien();
        try {
            sf = HibernateUtil.getSessionFactory();
            sf.getCurrentSession().beginTransaction();
            nhan_vien=  (Nhanvien) sf.getCurrentSession().get(Nhanvien.class,Integer.parseInt(ten_nhan_vien));
        } catch (Exception e) {
            return null;
        }finally{
            HibernateUtil.closeSessionFactory();
            return nhan_vien;
        }
    }
    public boolean delete(Nhanvien nhan_vien){
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
    public boolean saveorupdate(Nhanvien nhan_vien){
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
    public boolean query(Nhanvien nhan_vien){
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
