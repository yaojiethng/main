package seedu.jelphabot.logic;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.jelphabot.commons.core.GuiSettings;
import seedu.jelphabot.logic.commands.CommandResult;
import seedu.jelphabot.logic.commands.exceptions.CommandException;
import seedu.jelphabot.logic.parser.exceptions.ParseException;
import seedu.jelphabot.model.ReadOnlyJelphaBot;
import seedu.jelphabot.model.productivity.ProductivityList;
import seedu.jelphabot.model.task.SortedTaskList;
import seedu.jelphabot.model.task.Task;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     *
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException   If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the JelphaBot.
     *
     * @see seedu.jelphabot.model.Model#getJelphaBot()
     */
    ReadOnlyJelphaBot getJelphaBot();

    /**
     * Returns an unmodifiable view of the filtered list of tasks.
     */
    ObservableList<Task> getFilteredTaskList();

    /**
     * Returns an unmodifiable view of the filtered list of tasks in the Calendar.
     */
    ObservableList<Task> getFilteredCalendarTaskList();

    /**
     * Returns an unmodifiable view of the completed tasks in the task list.
     */
    ObservableList<Task> getFilteredByCompleteTaskList();

    /**
     * Returns an unmodifiable view of the incomplete tasks in the task list.
     */
    ObservableList<Task> getFilteredByIncompleteTaskList();

    /**
     * Returns a wrapper for categorised tasks in the task list.
     */
    SortedTaskList getSortedTaskList();

    /**
     * Returns an unmodifiable view of the incomplete tasks that are due today in
     * the task list.
     */
    ObservableList<Task> getFilteredByIncompleteDueTodayTaskList();

    /**
     * Returns an unmodifiable view of the user's productivity.
     */
    ProductivityList getProductivityList();

    /**
     * Returns the user prefs' address book file path.
     */
    Path getJelphaBotFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Returns the GUI settings for a popup window
     */
    GuiSettings getPopUpWindowGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Updates the filter of the filtered calendar task list to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredCalendarTaskList(Predicate<Task> predicate);
}
