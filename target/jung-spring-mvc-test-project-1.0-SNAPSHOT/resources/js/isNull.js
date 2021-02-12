function findId() {
    if (findIdForm.userName.value === "") {
        window.alert("이름을 입력해주세요.");
        findIdForm.userName.focus();
        return false;
    }

    if (findIdForm.userPhone.value === "") {
        window.alert("핸드폰 번호를 입력해주세요.");
        findIdForm.userPhone.focus();
        return false;
    }
}


function findPassword() {
    if (findPasswordForm.userName.value === "") {
        window.alert("이름을 입력해주세요.");
        findPasswordForm.userName.focus();
        return false;
    }

    if (findPasswordForm.userId.value === "") {
        window.alert("아이디를 입력해주세요.");
        findPasswordForm.userId.focus();
        return false;
    }

    if (findPasswordForm.userPhone.value === "") {
        window.alert("핸드폰 번호를 입력해주세요.");
        findPasswordForm.userPhone.focus();
        return false;
    }
}