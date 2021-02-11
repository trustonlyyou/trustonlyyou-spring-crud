// 비밀번호 중복 확인
function isSamePasswordCheck () {
    var password = document.getElementById('pw').value;
    var sc = ["!","@","#","$","%"];
    var checkSc = 0;

    if (password.length < 6 || password.length > 16) {
        window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
        document.getElementById('pw').value='';
        document.getElementById('pw').focus();
    }

    for (var i = 0; i < sc.length; i++) {
        if (password.indexOf(sc[i]) !== -1) {
            checkSc = 1;
        }
    }

    if (checkSc === 0) {
        window.alert('!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.')
        document.getElementById('pw').value='';
        document.getElementById('pw').focus();
    }

    if(document.getElementById('pw').value !=='' && document.getElementById('pw2').value !== ''){
        if(document.getElementById('pw').value === document.getElementById('pw2').value){
            document.getElementById('same').innerHTML='비밀번호가 일치합니다.';
            document.getElementById('same').style.color='blue';
        }
        else{
            document.getElementById('same').innerHTML='비밀번호가 일치하지 않습니다.';
            document.getElementById('same').style.color='red';
        }
    }
}