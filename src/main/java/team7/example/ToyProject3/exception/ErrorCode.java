package team7.example.ToyProject3.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	ENTITY_NOT_FOUND(HttpStatus.BAD_REQUEST, "요청하신 데이터가 없습니다."),
    ERROR_BIND_EXCEPTION(HttpStatus.BAD_REQUEST, ""),
    ERROR_BOARD_ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "없는 게시물 입니다."),

    ERROR_DUPLICATED_EMAIL_EXCEPTION(HttpStatus.BAD_REQUEST,"이미 존재하는 이메일 입니다."),
    ERROR_DUPLICATED_NICKNAME_EXCEPTION(HttpStatus.BAD_REQUEST,"이미 존재하는 닉네임 입니다."),


    UNSUPPORTED_FILE_EXTENSION(HttpStatus.BAD_REQUEST, "지원하지 않는 파일 확장자입니다."),
    FILE_UPLOAD_FAILED(HttpStatus.BAD_REQUEST, "파일 업로드에 실패하였습니다."),
    ALREADY_REPORTED_EXCEPTION(HttpStatus.BAD_REQUEST, "이미 신고한 게시글입니다.")
    ;

    final HttpStatus httpStatus;
    final String description;
}
