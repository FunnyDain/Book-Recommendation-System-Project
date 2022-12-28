
let devImgNum = 1;
function modal(devImgNum){
    document.getElementById("modalWin").style.display="block";
    // document

    if(devImgNum == 1){
        document.getElementById('devMovie1').src = '../assets/img/developer/알라딘.png';
        document.getElementById('devMovie2').src = '../assets/img/developer/어바웃타임.png';
        document.getElementById('devMovie3').src = '../assets/img/developer/엑시트.png';
    }else if(devImgNum == 2){
        document.getElementById('devMovie1').src = '../assets/img/developer/벼랑위의포뇨.png';
        document.getElementById('devMovie2').src = '../assets/img/developer/인사이드아웃.png';
        document.getElementById('devMovie3').src = '../assets/img/developer/트루먼쇼.png';
    }else if(devImgNum == 3){
        document.getElementById('devMovie1').src = '../assets/img/developer/수상한그녀.png';
        document.getElementById('devMovie2').src = '../assets/img/developer/말할수없는비밀.png';
        document.getElementById('devMovie3').src = '../assets/img/developer/바르게살자.png';
    }else if(devImgNum == 4){
        document.getElementById('devMovie1').src = '../assets/img/developer/청년경찰.png';
        document.getElementById('devMovie2').src = '../assets/img/developer/회사원.png';
        document.getElementById('devMovie3').src = '../assets/img/developer/헬로우고스트.png';
    }else{}


    // let slideNo = 0;   //슬라이드 번호용


}


let slideNo = 0;   //슬라이드 번호용

function slide(x){
    slideNo += x;
    if(slideNo>2) slideNo = 0;
    if(slideNo<0) slideNo = 2;

    let slideBox = document.getElementById('slideBox');  //슬라이드 박스
    let circle = document.getElementsByClassName('circle');  //서클버튼
    // circle[0]~circle[4]
    // let title = document.getElementsByClassName('title');  //제목문자
    // text[0]~text[4]


    let newX = ((slideNo)  * -100/3) + '%';   //이동할 위치 계산
    slideBox.style.transform = 'translateX('+newX+")";

    // 모든 서클버튼 초기화(투명, 원래 크기), 제목 문자 숨기기
    let a;
    for(a=0;  a<=2;  a++){
        circle[a].style.backgroundColor = "rgba(255,255,255,.3)";
        circle[a].style.transform = "scale(1)";
        // title[a].style.display = "none";
    }

    //해당 써클버튼 흰색배경, 40% 크게
    circle[slideNo].style.backgroundColor = "#fff";
    circle[slideNo].style.transform = "scale(1.4)";

    //해당 텍스트 보이기
    // title[slideNo].style.display = "block";

}

//서클 버튼 클릭했을 때 슬라이드 이동
function circle(x){
    slideNo = x;   //클릭한 서클버튼 위치를 슬라이드 번호로 맞춤
    slide(0);   //함수에 추가로 번호가 더해지지 않도록 0을 넘겨줌
}



