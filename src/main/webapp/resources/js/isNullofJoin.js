function isNullofInputValues() {
    if (joinForm.userName.value === "") {
        alert("이름을 입력해주세요.");
        joinForm.userName.focus();
        return false;
    }

    if (joinForm.userId.value === "") {
        alert("아이디를 입력해주세요.");
        joinForm.userId.focus();
        return false;
    }

    if (joinForm.userPassword.value === "") {
        alert("비밀번호를 입력해주세요.");
        joinForm.userPassword.focus();
        return false;
    }

    if (joinForm.userBirth.value === "") {
        alert("생년월일을 입력해주세요.");
        joinForm.userBirth.focus();
        return false;
    }

    if (joinForm.userPhone.value === "") {
        alert("핸드폰 번호를 입력해주세요.");
        joinForm.userPhone.focus();
        return false;
    }

    if (joinForm.userEmail.value === "") {
        alert("이메일을 입력해주세요.");
        joinForm.userEmail.focus();
        return false;
    }

    if (joinForm.postcode.value === "" || joinForm.address.value === "") {
        alert("주소를 선택해 주세요.");
        joinForm.postcode.focus();
        return false;
    }
}