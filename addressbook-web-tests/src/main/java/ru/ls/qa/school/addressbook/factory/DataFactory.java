package ru.ls.qa.school.addressbook.factory;

import com.github.javafaker.Faker;
import ru.ls.qa.school.addressbook.dto.data.ContactModelUi;
import ru.ls.qa.school.addressbook.dto.data.GroupModelUi;

public class DataFactory {
    private static final Faker faker = new Faker();

    private static String getRandomName() {
        return faker.name()
                    .firstName();
    }

    private static String getRandomMiddleName() {
        return faker.name()
                    .nameWithMiddle();
    }

    private static String getRandomLastName() {
        return faker.name()
                    .lastName();
    }

    private static String getRandomNickName() {
        return faker.name()
                    .username();
    }

    private static String getRandomTitle() {
        return faker.name()
                    .title();
    }

    private static String getRandomCompany() {
        return faker.company()
                    .name();
    }

    private static String getRandomAddress() {
        return faker.address()
                    .fullAddress();
    }

    private static String getRandomNumber() {
        return faker.phoneNumber()
                    .phoneNumber();
    }

    public ContactModelUi getRandomContactModelUi() {
        return ContactModelUi.builder()
                             .firstName(getRandomName())
                             .middleName(getRandomMiddleName())
                             .lastName(getRandomLastName())
                             .nickName(getRandomNickName())
                             .title(getRandomTitle())
                             .company(getRandomCompany())
                             .address(getRandomAddress())
                             .homePhone(getRandomNumber())
                             .mobilePhone(getRandomNumber())
                             .build();
    }

    public GroupModelUi getRandomGroupModelUi() {
        return GroupModelUi.builder()
                           .name(getRandomName())
                           .header(getRandomTitle())
                           .footer(getRandomTitle())
                           .build();
    }
}
