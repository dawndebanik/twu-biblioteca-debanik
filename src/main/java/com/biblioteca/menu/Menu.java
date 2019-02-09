package com.biblioteca.menu;

import com.biblioteca.UIDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Menu {
    private final Map<String, MenuOption> options;
    private final List<MenuOption> optionList;
    private final MenuOption defaultOption;
    private UIDriver uiDriver;

    public Menu(List<MenuOption> options, MenuOption defaultOption, UIDriver uiDriver) {
        this.optionList = new ArrayList<>();
        this.optionList.addAll(options);
        this.options = new HashMap<>();
        constructMenu(options);
        this.defaultOption = defaultOption;
        this.uiDriver = uiDriver;
    }

    public void select(String option) {
        options.getOrDefault(option, defaultOption).select();
    }

    void show() {
        uiDriver.show(this);
    }

    public List<String> getDisplayOptions() {
        return optionList.stream().map(MenuOption::nameOnScreen).collect(Collectors.toList());
    }

    private void constructMenu(List<MenuOption> options) {
        int listIndex = 1;
        for (MenuOption menuOption : options) {
            this.options.put(String.valueOf(listIndex), menuOption);
        }
    }
}
