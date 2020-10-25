package ru.job4j.tracker;

import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;


public class ReplaceActionTest {

    @Test
    public void execute() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Old name"));
        String replacedName = "New name";
        ReplaceAction rep = new ReplaceAction(out);
        List<Item> items = tracker.findByName("Old name");
        Input input = mock(Input.class);
        String id = items.get(0).getId();
        when(input.askInt(any(String.class))).thenReturn(Integer.valueOf(id));
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("==== The item is edited ===="+ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

}