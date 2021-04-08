import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException {


        Session session = HibernateConfig.getSession().openSession();
        Transaction transaction = session.beginTransaction();


        String hql = "From " + Purchaselist.class.getSimpleName();
        List<Purchaselist> purchaselists = session.createQuery(hql).getResultList();
        for (Purchaselist purchaselist : purchaselists) {
            String studentHql = "From " + Student.class.getSimpleName() + " student where student.name = " + "'" + purchaselist.getPurId().getStudentName() + "'";
            String courseHql = "From " + Course.class.getSimpleName() + " course where course.name = " + "'" + purchaselist.getPurId().getCourseName() + "'";
            Student students = (Student) session.createQuery(studentHql).setMaxResults(1).getResultList().get(0);
            Course courses = (Course) session.createQuery(courseHql).setMaxResults(1).getResultList().get(0);
            LinkedPurchaseList.Key key = new LinkedPurchaseList.Key();
            key.setStudentId(students);
            key.setCourseId(courses);
            session.save(new LinkedPurchaseList(key));
        }
        transaction.commit();
        session.close();
    }
}