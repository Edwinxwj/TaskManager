package sg.edu.rp.c346.taskmanager;

import java.io.Serializable;

/**
 * Created by 15056215 on 26/5/2017.
 */

public class Task implements Serializable {
    private int _id;
    private String name;
    private String description;

    public Task(int _id, String name, String description) {
        this._id = _id;
        this.name = name;
        this.description = description;
    }

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}
