import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.dto.data.ContactModelUi;
import ru.ls.qa.school.addressbook.page_objects.HomePage;

import static ru.ls.qa.school.addressbook.page_objects.LoginPage.open;

class ContactTest extends BaseUiTest {
    HomePage homePage;
    ContactModelUi contactDataForCreating = dataFactory.getRandomContactModelUi();
    ContactModelUi contactDataForEditing = dataFactory.getRandomContactModelUi();

    @BeforeEach
    void openLoginPage() {
        homePage = open().auth()
                         .getNavigationPanel()
                         .clickButtonAddNew()
                         .fillAllFields(contactDataForCreating)
                         .clickButtonEnterAndGoHomePage();
    }

    @Test
    @DisplayName("Проверка создания нового контакта")
    void checkAddNewContact() {
        homePage
                .checkContactIsVisible(contactDataForCreating)
                .getHeader()
                .clickButtonLogout();
    }

    @Test
    @DisplayName("Проверка редактирования контакта")
    void checkEditContact() {
        homePage
                .getContactByContactModel(contactDataForCreating)
                .clickButtonEdit()
                .fillAllFields(contactDataForEditing)
                .clickButtonUpdateAndGoHomePage()
                .checkContactIsVisible(contactDataForEditing);
    }

    @Test
    @DisplayName("Проверка удаления контакта")
    void checkDeleteContact() {
        homePage
                .clickCheckboxByContact(contactDataForCreating)
                .clickButtonDelete()
                .checkContactIsNotVisible(contactDataForCreating);
    }
}
