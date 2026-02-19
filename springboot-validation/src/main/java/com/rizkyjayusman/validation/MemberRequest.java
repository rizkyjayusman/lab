package com.rizkyjayusman.validation;

@MissingParamValidation(groups = {CreateGroup.class})
public class MemberRequest {
    @RequiredField
    private String name;
    @RequiredField
    private String email;
    @RequiredField
    @TransactionIdMinLen(value = 6, groups = {CreateGroup.class})
    @TransactionIdMaxLen(value = 16)
    private String trxId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }
}
