package seedu.jelphabot.model.task.tasklist;

import java.util.Collection;
import java.util.Iterator;

import seedu.jelphabot.commons.core.index.Index;
import seedu.jelphabot.model.task.Task;

/**
 * Represents a wrapper class for a list of tasks that are displayed in Ui.
 */
public interface ViewTaskList extends Collection<Task> {
    Task get(int id);

    Task get(Index index);

    int size();

    @Override
    Iterator<Task> iterator();
}
