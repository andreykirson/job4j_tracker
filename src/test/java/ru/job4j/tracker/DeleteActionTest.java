package ru.job4j.tracker;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DeleteActionTest {
    @Test
    public void execute() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Delete item"));
        tracker.add(new Item("New item"));
        DeleteAction del = new DeleteAction(out);
        List<Item> items = tracker.findByName("Delete item");
        Input input = mock(Input.class);
        String id = items.get(0).getId();
        when(input.askStr(any(String.class))).thenReturn(id);
        del.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("==== The item by id " + id + "is deleted ==="+ln));
        assertThat(tracker.findAll().size(), is(1));
    }
}