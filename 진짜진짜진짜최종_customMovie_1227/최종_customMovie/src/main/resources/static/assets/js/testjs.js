//joinform_check 함수로 유효성 검사
function joinform_check() {
    //변수에 담아주기
    let memberid = document.getElementById("memberid");
    let memberpassword = document.getElementById("memberpassword");
    let memberpasswordCheck = document.getElementById("memberpasswordCheck");
    let memberemail = document.getElementById("memberemail");
    let memberbirthday = document.getElementById("memberbirthday");
    let membernickname = document.getElementById("membernickname");
    let membermbti = document.getElementById("membermbti");


    if (memberid.value == "") { //해당 입력값이 없을 경우 같은말: if(!uid.value)
        alert("아이디를 입력하세요.");
        memberid.focus(); //focus(): 커서가 깜빡이는 현상, blur(): 커서가 사라지는 현상
        return false; //return: 반환하다 return false:  아무것도 반환하지 말아라 아래 코드부터 아무것도 진행하지 말것
    };

    // var idlength = /^{8,12}$/;
    // if (!idlength.test(memberid.value)) {
    //         alert("아이디는 8~12자리로 입력해주세요")
    //         memberid.focus();
    //         return false;
    // };



    if (memberpassword.value == "") {
        alert("비밀번호를 입력하세요.");

        memberpassword.focus();
        return false;
    };


    //비밀번호 영문자+숫자+특수조합(8~25자리 입력) 정규식
    var pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;

    if (!pwdCheck.test(memberpassword.value)) {
        alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
        memberpassword.focus();
        return false;
    };

    if (memberpasswordCheck.value != memberpassword.value) {
        alert("비밀번호가 일치하지 않습니다.");
        memberpasswordCheck.focus();
        return false;
    };

    if (memberemail.value == "") {
        alert("이메일 주소를 입력하세요.");
        memberemail.focus();
        return false;
    }

    if (memberbirthday.value == "") {
        alert("생년월일을 다시 입력해주세요. ex)19990101");
        memberbirthday.focus();
        return false;
    };

    if (membernickname.value == "") {
        alert("닉네임을 입력해주세요.");
        membernickname.focus();
        return false;
    };

    if (membermbti.value == "") {
        alert("mbti를 다시 입력해주세요");
        membermbti.focus();
        return false;
    };

    //입력 값 전송
    document.join_form.submit(); //유효성 검사의 포인트
}

//아이디 중복체크 팝업창(현재 공백문서)
function idCheck() {
    //window.open("팝업될 문서 경로", "팝업될 문서 이름", "옵션");
        window.open("/idCheck.html", "idwin", "width=600, height=200, left=200, top=100");

}

//이메일 옵션 선택후 주소 자동 완성
function change_email() {
    var memberemail_add = document.getElementById("memberemail_add");
    var memberemail_sel = document.getElementById("memberemail_sel");

    //지금 골라진 옵션의 순서와 값 구하기
    var idx = memberemail_sel.options.selectedIndex;
    var val = memberemail_sel.options[idx].value;

    memberemail_add.value = val;



}