package ru.ls.qa.school.addressbook.page_objects;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import ru.ls.qa.school.addressbook.dto.data.ContactModelUi;
import ru.ls.qa.school.addressbook.page_objects.components.Header;
import ru.ls.qa.school.addressbook.page_objects.components.NavigationPanel;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class ContactPage extends BasePage {
    private final NavigationPanel navigationPanel;
    private final Header header;
    @As("Полле ввода [First name]")
    private final SelenideElement inputFirstName = $("input[name*=first]");
    @As("Полле ввода [Middle name]")
    private final SelenideElement inputMiddleName = $("input[name*=mid]");
    @As("Полле ввода [Last name]")
    private final SelenideElement inputLastName = $("input[name*=last]");
    @As("Полле ввода [Nick name]")
    private final SelenideElement inputNickName = $("input[name*=nick]");
    @As("Полле ввода [Company]")
    private final SelenideElement inputCompany = $("input[name*=com]");
    @As("Полле ввода [Title]")
    private final SelenideElement inputTitle = $("input[name*=tit]");
    @As("Полле ввода [Address]")
    private final SelenideElement inputAddress = $("textarea[name=address]");
    @As("Полле ввода [Home] для Telephone")
    private final SelenideElement inputHomePhone = $("input[name=home]");
    @As("Полле ввода [Mobile] для Telephone")
    private final SelenideElement inputMobilePhone = $("input[name*=mob]");
    @As("Кнопка [Enter]")
    private final SelenideElement buttonEnter = $("input[type*=submit]");
    @As("Текст страницы")
    private final SelenideElement pagesText = $x("//h1[text()='Edit / add address book entry']");
    @As("Сообщение успешного добавления")
    private final SelenideElement informationEnteredMessage = $("div[class=msgbox]");
    @As("Кнопка [Add next]")
    private final SelenideElement buttonAddNext = $x("//a[text()='add next']");
    @As("Кнопка возврата на [Home page]")
    private final SelenideElement buttonReturnToHomePage = $x("//a[text()='home page']");

    public ContactPage() {
        pagesText.shouldBe(visible);
        navigationPanel = new NavigationPanel();
        header = new Header();
    }

    public ContactPage fillAllFields(ContactModelUi contact) {
        setValueIntoInput(inputFirstName, contact.getFirstName());
        setValueIntoInput(inputMiddleName, contact.getMiddleName());
        setValueIntoInput(inputLastName, contact.getLastName());
        setValueIntoInput(inputNickName, contact.getNickName());
        setValueIntoInput(inputCompany, contact.getCompany());
        setValueIntoInput(inputTitle, contact.getTitle());
        setValueIntoInput(inputAddress, contact.getAddress());
        setValueIntoInput(inputHomePhone, contact.getHomePhone());
        setValueIntoInput(inputMobilePhone, contact.getMobilePhone());
        return this;
    }

    public HomePage clickButtonEnterAndGoHomePage() {
        buttonEnter.shouldBe(visible)
                   .click();
        informationEnteredMessage.shouldBe(visible);
        buttonAddNext.shouldBe(visible);
        return buttonReturnToHomePage.is(visible) ? clickButtonReturnToHomePage() : navigationPanel.clickButtonHome();
    }

    public HomePage clickButtonReturnToHomePage() {
        buttonReturnToHomePage.shouldBe(visible)
                              .click();
        return new HomePage();
    }

    public HomePage clickButtonUpdateAndGoHomePage() {
        buttonEnter.shouldBe(visible)
                   .click();
        informationEnteredMessage.shouldBe(visible);
        return buttonReturnToHomePage.is(visible) ? clickButtonReturnToHomePage() : navigationPanel.clickButtonHome();
    }

}
