package ru.ls.qa.school.addressbook.page_objects;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NotFoundException;
import ru.ls.qa.school.addressbook.dto.data.GroupModelUi;
import ru.ls.qa.school.addressbook.page_objects.components.Group;
import ru.ls.qa.school.addressbook.page_objects.components.Header;
import ru.ls.qa.school.addressbook.page_objects.components.NavigationPanel;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


@Getter
public class GroupsPage {
    private final NavigationPanel navigationPanel;
    private final Header header;
    @As("Кнопка [New group]")
    private final SelenideElement buttonNewGroup = $("input[name=new]");
    @As("Кнопка [Delete]")
    private final SelenideElement buttonDelete = $("input[name=delete]");
    @As("Кнопка [Edit]")
    private final SelenideElement buttonEdit = $("input[name=edit]");
    private List<Group> groups;

    public GroupsPage() {
        navigationPanel = new NavigationPanel();
        header = new Header();
        buttonDelete.shouldBe(visible);
        buttonNewGroup.shouldBe(visible);
        buttonEdit.shouldBe(visible);
        groups = initGroup();
    }

    private List<Group> initGroup() {
        return $$("span[class*=group]")
                .asFixedIterable()
                .stream()
                .map(Group::new)
                .collect(Collectors.toList());
    }

    public Group getGroupByGroupModel(GroupModelUi groupModelUi) {
        return initGroup()
                .stream()
                .filter(group -> group.getGroupName()
                                      .contains(groupModelUi.getName()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Группа не найдена"));
    }

    public GroupsPage checkGroupIsVisible(GroupModelUi groupModelUi) {
        getGroupByGroupModel(groupModelUi);
        return this;
    }

    public GroupPage clickButtonNewGroup() {
        buttonNewGroup.shouldBe(visible)
                      .click();
        return new GroupPage();
    }

    public GroupsPage checkGroupIsNotVisible(GroupModelUi groupModelUi) {
        Assertions.assertTrue(initGroup()
                                      .stream()
                                      .noneMatch(group -> group.getGroupName()
                                                               .contains(groupModelUi.getName())
                                      ), "Группа видна, хотя не должна быть");
        return this;
    }

    public GroupsPage clickCheckboxByGroupModel(GroupModelUi groupModelUi) {
        getGroupByGroupModel(groupModelUi)
                .clickCheckbox();
        return this;
    }

    public GroupPage clickButtonEdit() {
        buttonEdit.shouldBe(visible)
                .click();
        return new GroupPage();
    }

    public GroupsPage clickButtonDelete() {
        buttonDelete.shouldBe(visible)
                  .click();
        return this;
    }
}
