package com.biblioteca.menu;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<String, MenuOption> options;
    private final MenuOption defaultOption;

    public Menu(Map<String, MenuOption> options, MenuOption defaultOption) {
        this.options = new HashMap<>(options);
        this.defaultOption = defaultOption;
    }

    public void select(String option) {
        options.getOrDefault(option, defaultOption).select();
    }

}
