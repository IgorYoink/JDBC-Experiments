
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @EmbeddedId
    private SubscriptionKey key;


    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @EqualsAndHashCode
    @ToString
    @Embeddable
    public class SubscriptionKey implements Serializable {

        public SubscriptionKey() {
        }

        public SubscriptionKey(Student student, Course course) {
            this.student = student;
            this.course = course;
        }

        static final long serialVersionUID = 1L;


        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "student_id")
        private Student student;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "course_id")
        private Course course;

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
        }
    }
}
