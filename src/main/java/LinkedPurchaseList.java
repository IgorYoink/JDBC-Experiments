import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "linked_purchaselist")
public class LinkedPurchaseList {

    @EmbeddedId
    private Key key;

    public LinkedPurchaseList(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }


    @EqualsAndHashCode
    @Embeddable
    public static class Key implements Serializable {

        public Key() {
        }

        public Key(Student studentId, Course courseId) {
            this.studentId = studentId;
            this.courseId = courseId;
        }

        static final long serialVersionUID = 1L;

        @ManyToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "student_id", insertable = false, updatable = false)
        private Student studentId;

        @ManyToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "course_id", insertable = false,updatable = false)
        private Course courseId;

        public Student getStudentId() {
            return studentId;
        }

        public void setStudentId(Student studentId) {
            this.studentId = studentId;
        }

        public Course getCourseId() {
            return courseId;
        }

        public void setCourseId(Course courseId) {
            this.courseId = courseId;
        }
    }
}
