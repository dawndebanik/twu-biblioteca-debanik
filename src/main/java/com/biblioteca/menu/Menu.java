package com.biblioteca.menu;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<String, MenuOption> options;
    public Menu(Map<String, MenuOption> options){
        this.options = new HashMap<>(options);
    }

    public void select(String option) {
        options.get(option).select();
    }
}
