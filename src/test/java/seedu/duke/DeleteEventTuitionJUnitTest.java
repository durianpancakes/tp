package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.exception.EmptyParameterException;
import seedu.duke.exception.MissingParameterException;
import seedu.duke.model.event.Event;
import seedu.duke.model.event.classlesson.EventClassManager;
import seedu.duke.model.event.tuition.EventTuition;
import seedu.duke.model.event.tuition.EventTuitionManager;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeleteEventTuitionJUnitTest {
    @Test
    void deleteTuition_validIndex() {
        EventTuitionManager eventTuitionManager = new EventTuitionManager(getTuitionList());

        String [] userInput = "delete tuition 1".trim().split(" ");

        try {
            eventTuitionManager.delete(userInput);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        int actualOutputs = eventTuitionManager.getTuitionListSize();
        int expectedOutputs = 1;

        assertEquals(actualOutputs, expectedOutputs);
    }

    @Test
    void deleteTuition_invalidIndex_exceptionThrown() {
        EventTuitionManager eventTuitionManager = new EventTuitionManager(getTuitionList());

        String [] userInputIndexTooLarge = "delete tuition 5".trim().split(" ");
        String [] userInputIndexNegative = "delete tuition -1".trim().split(" ");

        assertThrows(IndexOutOfBoundsException.class, () -> eventTuitionManager.delete(userInputIndexTooLarge));
        assertThrows(IndexOutOfBoundsException.class, () -> eventTuitionManager.delete(userInputIndexNegative));
    }

    private ArrayList<Event> getTuitionList() {
        ArrayList<Event> tuitions = new ArrayList<>();

        tuitions.add(new EventTuition("math", "2020-09-26 1400",
                "2020-09-26 1500", "home"));
        tuitions.add(new EventTuition("english", "2020-09-27 1400",
                "2020-09-27 1500", "tuition centre"));

        return tuitions;
    }
}
