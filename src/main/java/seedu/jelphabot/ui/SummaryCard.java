package seedu.jelphabot.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.jelphabot.model.summary.Summary;

/**
 * A UI Component that displays information of a {@code Summary}.
 */
public class SummaryCard extends UiPart<Region> {

    private static final String FXML = "SummaryCard.fxml";

    private static final String BREAKLINE_STRING = "--------------------------------------------------";

    private Summary summary;

    @FXML
    private Label breakline;

    @FXML
    private Label tasksDueToday;

    @FXML
    private Label tasksCompletedToday;

    public SummaryCard(Summary summary) {
        super(FXML);
        this.summary = summary;
        breakline.setText(BREAKLINE_STRING);
        tasksDueToday.setText(summary.getTasksDueToday().getTasksDueTodayString());
        tasksCompletedToday.setText(summary.getTasksCompletedToday().getTasksCompletedTodayString());
    }

    @Override
    public boolean equals(Object other) {
        //short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SummaryCard)) {
            return false;
        }

        // state check
        SummaryCard summaryCard = (SummaryCard) other;
        return breakline.getText().equals(summaryCard.breakline.getText())
            && tasksDueToday.getText().equals(summaryCard.tasksDueToday.getText())
            && tasksCompletedToday.getText().equals(summaryCard.tasksCompletedToday.getText());
    }
}
