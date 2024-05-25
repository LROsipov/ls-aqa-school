package ru.ls.qa.school.addressbook.dto.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactModelUi {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String nickName;
    private final String title;
    private final String company;
    private final String address;
    private final String homePhone;
    private final String mobilePhone;
}
