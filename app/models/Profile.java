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
    public String FName;
    public String LName;
    public String Company;
}
