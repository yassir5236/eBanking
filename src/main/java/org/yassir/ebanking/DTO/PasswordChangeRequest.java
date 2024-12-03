package org.yassir.ebanking.DTO;

public record PasswordChangeRequest(
         String oldPassword,
         String newPassword
) {
}
