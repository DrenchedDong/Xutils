package dongting.bwei.com.xutils;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * 作者:${董婷}
 * 日期:2017/5/8
 * 描述:
 */

@Table(name="student")
public class Student {
    @Column(name ="id",isId = true,autoGen = true)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
