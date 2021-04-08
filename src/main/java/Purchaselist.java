import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "purchaselist")
public class Purchaselist {

    @Id
    @EmbeddedId
    private PurchaselistKey purId;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public PurchaselistKey getPurId() {
        return purId;
    }

    public void setPurId(PurchaselistKey purId) {
        this.purId = purId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @EqualsAndHashCode
    @Embeddable
    public static class PurchaselistKey implements Serializable {

        public PurchaselistKey(){
        }

        public PurchaselistKey(String studentName, String courseName) {
            this.studentName = studentName;
            this.courseName = courseName;
        }

        static final long serialVersionUID = 1L;

        @Column(name = "student_name")
        private String studentName;

        @Column(name = "course_name")
        private String courseName;

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }
    }
}
