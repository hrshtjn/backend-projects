package org.example.forkjoin.second;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class NewTask extends RecursiveAction {

    private long Load=0;

    public NewTask(long Load) { this.Load = Load; }

    @Override
    protected void compute() {
        // fork tasks into smaller subtasks
        List<NewTask> subtasks = new ArrayList<NewTask>();
        subtasks.addAll(createSubtasks());

        for (RecursiveAction subtask : subtasks) {
            subtask.fork();
        }
    }

    // function to create and add subtasks
    private List<NewTask> createSubtasks()
    {
        // create subtasks
        List<NewTask> subtasks = new ArrayList<NewTask>();
        NewTask subtask1 = new NewTask(this.Load / 2);
        NewTask subtask2 = new NewTask(this.Load / 2);
        NewTask subtask3 = new NewTask(this.Load / 2);

        // to add the subtasks
        subtasks.add(subtask1);
        subtasks.add(subtask2);
        subtasks.add(subtask3);

        return subtasks;
    }
}
