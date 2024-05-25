package ru.ls.qa.school.addressbook.page_objects.components;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class Group {
    private final SelenideElement root;
    private final SelenideElement checkbox;
    @As("Название группы")
    private final String groupName;

    public Group(SelenideElement root) {
        this.root = root;
        this.checkbox = root.$("input")
                            .as("Чекбокс");
        this.groupName = root.getText();
    }
}
