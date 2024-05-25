package ru.ls.qa.school.addressbook.dto.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupModelUi {
    private final String name;
    private final String header;
    private final String footer;
}
