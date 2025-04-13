package com.myproject.mapper;

import org.mapstruct.*;
import com.myproject.dto.*;
import com.myproject.model.Email;
import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmailMapper {
    EmailBasicDTO toEmailBasicDTO(Email email);
    EmailDetailDTO toEmailDetailDTO(Email email);

    List<EmailBasicDTO> toEmailBasicDTOs(List<Email> emails);
    List<EmailDetailDTO> toEmailDetailDTOs(List<Email> emails);

    // Add your custom mapping methods here
}
