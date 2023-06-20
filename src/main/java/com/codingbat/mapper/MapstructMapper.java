package com.codingbat.mapper;

import com.codingbat.dto.LanguageDTO;
import com.codingbat.dto.ResultDTO;
import com.codingbat.dto.TaskDTO;
import com.codingbat.dto.UserDTO;
import com.codingbat.entity.Language;
import com.codingbat.entity.Result;
import com.codingbat.entity.Task;
import com.codingbat.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
@Component
public interface MapstructMapper {

    User toUser(UserDTO userDTO);
    User toUser(@MappingTarget User user, UserDTO userDTO);
    UserDTO toUserDTO(User user);

    Language toLanguage(LanguageDTO languageDTO);
    Language toLanguage(@MappingTarget Language language, LanguageDTO languageDTO);
    LanguageDTO toLanguageDTO(Language language);

    Result toResult(ResultDTO resultDTO);
    Result toResult(@MappingTarget Result result, ResultDTO resultDTO);
    ResultDTO toResultDTO(Result result);

    Task toTask(TaskDTO taskDTO);
    Task toTask(@MappingTarget Task task, TaskDTO taskDTO);
    TaskDTO toTaskDTO(Task task);
}
