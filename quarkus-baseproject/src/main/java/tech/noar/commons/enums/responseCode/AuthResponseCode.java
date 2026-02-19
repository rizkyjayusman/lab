package tech.noar.commons.enums.responseCode;

import jakarta.ws.rs.core.Response.Status;
import tech.noar.commons.ServiceResponseCode;

public enum AuthResponseCode implements ServiceResponseCode {
    PASSWORD_NOT_MATCH(Status.BAD_REQUEST, "PASSWORD_NOT_MATCH", "Konfirmasi kata sandi harus sama."),

    EMAIL_ALREADY_REGISTERED(Status.BAD_REQUEST, "EMAIL_ALREADY_REGISTERED", "Email sudah terdaftar!"),
    USERNAME_ALREADY_REGISTERED(Status.BAD_REQUEST, "USERNAME_ALREADY_REGISTERED", "Username sudah terdaftar!"),
    PHONE_NUMBER_ALREADY_REGISTERED(Status.BAD_REQUEST, "PHONE_NUMBER_ALREADY_REGISTERED",
            "Nomor Telephone sudah terdaftar!"),

    PHONE_NUMBER_NOT_VALID(Status.BAD_REQUEST, "PHONE_NUMBER_NOT_VALID",
            "Nomor ponsel hanya boleh diawali dengan +62/62/08 dan angka minimum 10 dan maksimum 13 digit."),
    ACCOUNT_NOT_FOUND(Status.BAD_REQUEST, "ACCOUNT_NOT_FOUND", "Akun tidak terdaftar."),
    ACCOUNT_ALREADY_ACTIVE(Status.BAD_REQUEST, "ACCOUNT_ALREADY_ACTIVE", "Akun sudah aktif."),


    BUSINESS_TYPE_NOT_FOUND(Status.BAD_REQUEST, "BUSINESS_TYPE_NOT_FOUND", "tipe bisnis akun tidak tersedia."),
    ROLE_NOT_FOUND(Status.BAD_REQUEST, "ROLE_NOT_FOUND", "role tidak tersedia."),

    CREATE_ACCOUNT_SUCCESS(Status.OK, "CREATE_ACCOUNT_SUCCESS", "Success create account"),
    FORGOT_PASSWORD_SEND_MAIL(Status.OK, "FORGOT_PASSWORD_SEND_MAIL", "Success send forgot password mail."),
    FORGOT_PASSWORD_SUCCESS(Status.OK, "FORGOT_PASSWORD_SUCCESS", "Kata sandi berhasil diubah."),

    ;

    private Status httpsStatus;
    private String code;
    private String message;

    AuthResponseCode(Status httpsStatus, String code, String message) {
        this.httpsStatus = httpsStatus;
        this.code = code;
        this.message = message;
    }

    @Override
    public Status getHttpStatus() {
        return this.httpsStatus;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
