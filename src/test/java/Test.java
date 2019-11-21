import com.mqx.po.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test {
    private  SessionFactory sessionFactory;
    private Session session;
    private  Transaction tx;
    @org.junit.Before
    public  void  before(){
        Configuration configur=new Configuration().configure();
        sessionFactory=configur.buildSessionFactory();
        session=sessionFactory.openSession();
        tx=session.beginTransaction();
    }
    @org.junit.Test
    public  void  testGet(){
        Student student = session.get(Student.class, 1);
        System.out.println("student = " + student);
    }
    @org.junit.Test
    public  void  testLoad(){
        Student student=session.load(Student.class,1);
        System.out.println("student = " + student);
    }
    @org.junit.After
    public  void  after(){
        tx.commit();
        session.close();
    }
    @org.junit.Test
    public void DeleteTest() {
        Student stu=session.get(Student.class,3);
        if(stu!=null){
            session.delete(stu);
        }
    }
    @org.junit.Test
    public void UpdateTest() {
   Student stu=session.get(Student.class,1);
   stu.setName("张毅");
   if(stu!=null){
       session.update(stu);
   }
    }
    @org.junit.Test
    public void InsertTest() {
        Student stu=new Student();
        stu.setName("赵六");
        session.save(stu);
    }
    @org.junit.Test
    public  void  testSaveOrUpdate(){
        Student stu=new Student();
        stu.setName("嘻嘻");
        session.saveOrUpdate(stu);
    }

//    @org.junit.Test
//    public void test() {
////    1.获取SessionFactory 会话工厂
//        SessionFactory sessionFactory=
//                new Configuration().configure().buildSessionFactory();
////        2.生产会话通过openSession 获取session 对象
//          Session session =sessionFactory.openSession();
////          3.开启一个事务
//        Transaction transaction = session.beginTransaction();
////       执行查询 get(要查询的实体类型,参数)
//       Student student=session.get(Student.class,1);
//        System.out.println("student="+student);
////    4.2执行查询（查询单条）
//        Student student1 = session.get(Student.class, 1);
//        System.out.println("student1="+student1);
////        4.3执行查询（单条执行） hql 语句
//        String hql1="from Student where id=?";
//        String hql2="from Student where id=:id";
//        Query query = session.createQuery(hql2);
////        query.setParameter(0,1);hql1传值  占位符从0开始
//        query.setParameter("id",1);//hql2传值 自定义占位符
//        Object o = query.uniqueResult();//只针对于 已经知道只有一条语句时才能使用
//        System.out.println("o="+o);
////        5.查询全部
////        访问实体类
//        Query query1 = session.createQuery("from Student");
//        List<Student> list = query1.list();
//        for (Student stu : list) {
//            System.out.println("stu = " + stu);
//        }
////        transaction.commit();//提交一次事物
////        session.close();//关闭session
////        session=sessionFactory.openSession();
////        transaction=session.beginTransaction();
//
//    }


}