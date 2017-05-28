package sg.edu.rp.c346.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by 15056215 on 26/5/2017.
 */

public class TaskArrayAdapter extends ArrayAdapter<Task> {

    Context context;
    ArrayList<Task> tasks;
    int resource;

    public TaskArrayAdapter(Context context, int resource, ArrayList<Task> tasks) {
        super(context, resource, tasks);
        this.context = context;
        this.tasks = tasks;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);


        TextView tvName = (TextView) rowView.findViewById(R.id.tvTaskName);
        TextView tvDescription = (TextView) rowView.findViewById(R.id.tvTaskContent);

        Task task = tasks.get(position);
        String name = task.getName();
        String description = task.getDescription();


        tvName.setText(name);
        tvDescription.setText(description);

        return rowView;
    }


}

