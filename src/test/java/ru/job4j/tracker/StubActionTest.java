//package ru.job4j.tracker;
//
//import org.junit.Test;
//
//import static org.hamcrest.Matchers.is;
//import static org.junit.Assert.assertThat;
//
//public class StubActionTest {
//
//
//    @Test
//    public void whenExit() {
//        StubInput input = new StubInput(
//                new String[] {"0"}
//        );
//        StubAction action = new StubAction();
//        new StartUI().init(input, new MemTracker(), new UserAction[] { action });
//        assertThat(action.isCall(), is(true));
//    }
//}