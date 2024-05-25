import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.dto.data.ContactModelUi;
import ru.ls.qa.school.addressbook.page_objects.LoginPage;

class ContactTest extends BaseUiTest {
    LoginPage loginPage;
    ContactModelUi contactData = dataFactory.getRandomContactModelUi();

    @BeforeEach
    void openLoginPage() {
        loginPage = LoginPage.open();
    }

    @Test
    @DisplayName("Проверка создания нового контакта")
    void checkAddNewContact() {
        loginPage
                .auth()
                .getNavigationPanel()
                .clickButtonAddNew()
                .fillAllFields(contactData)
                .clickButtonEnterAndGoHomePage()
                .checkContactIsVisible(contactData)
                .getHeader()
                .clickButtonLogout();
    }
}
