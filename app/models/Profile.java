package models;


import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lubuntu on 8/20/16.
 */
@Entity
public class Profile extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String firstName;
    public String lastName;
    public String company;

    public static Finder<Long, Profile> find = new Finder<Long, Profile>(Profile.class);

    public Profile(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
