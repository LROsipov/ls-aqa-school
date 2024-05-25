import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.dto.data.GroupModelUi;
import ru.ls.qa.school.addressbook.page_objects.GroupsPage;
import ru.ls.qa.school.addressbook.page_objects.LoginPage;

class GroupTest extends BaseUiTest {
    GroupsPage groupsPage;
    GroupModelUi groupModelUi = dataFactory.getRandomGroupModelUi();

    @BeforeEach
    void openLoginPage() {
        groupsPage = LoginPage.open()
                              .auth()
                              .getNavigationPanel()
                              .clickGroups();
    }

    @Test
    @DisplayName("Проверка создания новой группы")
    void checkAddNewGroup() {
        groupsPage
                .clickButtonNewGroup()
                .fillAllFields(groupModelUi)
                .clickButtonEnterInformationAndGoToGroupPage()
                .checkGroupIsVisible(groupModelUi)
                .getHeader()
                .clickButtonLogout();
    }
}
