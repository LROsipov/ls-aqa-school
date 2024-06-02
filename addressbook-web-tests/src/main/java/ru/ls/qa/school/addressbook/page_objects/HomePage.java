package ru.ls.qa.school.addressbook.page_objects;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NotFoundException;
import ru.ls.qa.school.addressbook.dto.data.ContactModelUi;
import ru.ls.qa.school.addressbook.page_objects.components.Contact;
import ru.ls.qa.school.addressbook.page_objects.components.Header;
import ru.ls.qa.school.addressbook.page_objects.components.NavigationPanel;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Getter
public class HomePage {
    private final NavigationPanel navigationPanel;
    private final Header header;
    @As("Текст страницы")
    private final SelenideElement pagesText = $x("//strong[text()='Number of results: ']");
    private List<Contact> contacts;
    @As("Кнопка [Home page]")
    private final SelenideElement buttonDelete = $("input[value*=Del]");

    public HomePage() {
        pagesText.shouldBe(visible);
        navigationPanel = new NavigationPanel();
        header = new Header();
        contacts = initContacts();
    }

    private List<Contact> initContacts() {
        return $$x("//tr[@name='entry']")
                .asFixedIterable()
                .stream()
                .map(Contact::new)
                .collect(Collectors.toList());
    }

    public HomePage checkContactIsVisible(ContactModelUi contactModelUi) {
        getContactByContactModel(contactModelUi);
        return this;
    }

    public Contact getContactByContactModel(ContactModelUi contactModelUi) {
        return initContacts()
                .stream()
                .filter(contact ->
                                contact.getLastName()
                                       .is(text(contactModelUi.getLastName()))
                                        && contact.getFistName()
                                                  .is(text(contactModelUi.getFirstName()))
                                        && contact.getAddress()
                                                  .is(text(contactModelUi.getAddress()))
                )
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Контакт не был найден"));
    }

    public HomePage clickButtonDelete() {
        buttonDelete.shouldBe(visible)
                .click();
        return this;
    }

    public HomePage clickCheckboxByContact(ContactModelUi contactModelUi) {
        getContactByContactModel(contactModelUi).clickCheckbox();
        return this;
    }

    public HomePage checkContactIsNotVisible(ContactModelUi contactModelUi) {
        Assertions.assertTrue(initContacts()
                                      .stream()
                                      .noneMatch(contact ->
                                                         contact.getLastName().is(text(contactModelUi.getLastName()))
                                                                 && contact.getFistName().is(text(contactModelUi.getFirstName()))
                                                                 && contact.getAddress().is(text(contactModelUi.getAddress()))
                                      ), "Контакт виден, хотя не должен быть");
        return this;
    }
}
