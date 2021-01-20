package ru.job4j.tracker;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StartUI {

    private ConsoleInput input;

    public StartUI(ConsoleInput input) {
        this.input = input;
    }

    public void init(Store store, UserAction[] actions) throws Exception {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, store);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j.tracker");
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            UserAction[] actions = {
                    new CreateAction(),
                    new FindAllAction(),
                    new FindByNameAction(),
                    new DeleteAction(),
                    new FindByIdAction(),
                    new ExitAction()
            };
            ui.init(tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
