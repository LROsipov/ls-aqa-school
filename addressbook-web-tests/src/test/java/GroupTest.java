import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.dto.data.GroupModelUi;
import ru.ls.qa.school.addressbook.page_objects.GroupsPage;
import ru.ls.qa.school.addressbook.page_objects.LoginPage;

class GroupTest extends BaseUiTest {
    GroupsPage groupsPage;
    GroupModelUi groupModelUiForCreating = dataFactory.getRandomGroupModelUi();
    GroupModelUi groupModelUiForEditing = dataFactory.getRandomGroupModelUi();

    @BeforeEach
    void openLoginPage() {
        groupsPage = LoginPage.open()
                              .auth()
                              .getNavigationPanel()
                              .clickGroups()
                              .clickButtonNewGroup()
                              .fillAllFields(groupModelUiForCreating)
                              .clickButtonSubmitAndGoToGroupPage();
    }

    @Test
    @DisplayName("Проверка создания новой группы")
    void checkAddNewGroup() {
        groupsPage
                .checkGroupIsVisible(groupModelUiForCreating)
                .getHeader()
                .clickButtonLogout();
    }

    @Test
    @DisplayName("Проверка редактирования группы")
    void checkEditGroup() {
        groupsPage
                .clickCheckboxByGroupModel(groupModelUiForCreating)
                .clickButtonEdit()
                .fillAllFields(groupModelUiForEditing)
                .clickButtonSubmitAndGoToGroupPage()
                .checkGroupIsVisible(groupModelUiForEditing);
    }

    @Test
    @DisplayName("Проверка редактирования группы")
    void checkDeleteGroup() {
        groupsPage
                .clickCheckboxByGroupModel(groupModelUiForCreating)
                .clickButtonDelete()
                .checkGroupIsNotVisible(groupModelUiForCreating);
    }
}
