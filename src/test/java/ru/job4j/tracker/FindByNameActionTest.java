package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {

    @Test
    void execute() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("New item"));
        FindByNameAction findByName = new FindByNameAction(out);
        List<Item> items = tracker.findAll();
        Input input = mock(Input.class);
        String id = items.get(0).getId();
        when(input.askStr(any(String.class))).thenReturn("New item");
        findByName.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is( "Item{id = " + id + '\'' + ", name = 'New item'}"+ln));
        assertThat(items.get(0).getName(), is("New item"));
    }
}