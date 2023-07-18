package team7.example.ToyProject3.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    NOMAL("NORMAL"),
    VIP("VIP"),
    BLACK("BLACKLIST");

    private String value;
}
