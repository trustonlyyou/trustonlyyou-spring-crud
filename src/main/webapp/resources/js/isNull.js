function findId() {
    if (findIdForm.userName.value === "") {
        alert("이름을 입력해주세요.");
        findIdForm.userName.focus();
        return false;
    }

    if (findIdForm.userPhone.value === "") {
        alert("핸드폰 번호를 입력해주세요.");
        findIdForm.userPhone.focus();
        return false;
    }
}
// <tr>
// <td>이름 </td><td><label><input type="text" name="userName" size="15"></label></td>
// </tr>
// <tr>
// <td>핸드폰 번호 </td><td><label><input type="text" name="userPhone" size="20"></label></td>
// </tr>