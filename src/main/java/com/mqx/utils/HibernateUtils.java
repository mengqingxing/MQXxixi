package com.mqx.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
/**
 * @authordell
 * @Create2019-11-21-11:06
 */
public class HibernateUtils {
    private static   SessionFactory sessionFactory;
    private static Session session;
    private static Transaction tx;


    static {
        Configuration configur=new Configuration().configure();
        sessionFactory=configur.buildSessionFactory();
        session=sessionFactory.openSession();
        tx=session.beginTransaction();
    }


    public  static Session getSession(){
    return  session;
    }
    public  static  Query getQuery(String hql){
        return  session.createQuery(hql);
    }
    public  static  void  closeSession(){
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
