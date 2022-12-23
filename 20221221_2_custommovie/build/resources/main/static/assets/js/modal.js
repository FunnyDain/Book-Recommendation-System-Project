
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

    
    //슬라이드
    
    // let slideNo = 0;    //슬라이드 번호용(0~3)
    //
    // //가로 방향으로  슬라이드되는 이미지
    // function slide(x){
    //     slideNo += x;   //슬라이드 번호를 x만큼 변화
    //
    //     if(slideNo>3) slideNo=0;
    //     if(slideNo<0) slideNo=3;
    //
    //     let box = document.getElementById('imageBox');   //슬라이드 이미지박스
    //
    //
    //     let newX = ((slideNo) * -(100/3)) + '%';
    //     // box.style.transform = 'translateX('+newX+")";
    //     // let newX = (slideNo * -100) + '%';  //이미지 번호별 슬라이드박스 가로 위치
    //     box.style.marginLeft = newX;
    //
    //     let circle = document.getElementsByClassName('circle');    //서클버튼
    //
    //     // 써클버튼 모두 투명
    //     for(let a=0;  a<=3;  a++){
    //         circle[a].style.backgroundColor = "transparent";
    //     }
    //
    //     //해당 써클버튼 흰색배경
    //     circle[slideNo].style.backgroundColor = "#fff";
    //
    //
    // }    //end slide()
    //
    // function circle(x){
    //     slideNo = x;   //슬라이드 번호를 서클버튼 순번과 맞춤
    //     slide(0);    //슬라이드 동작
    // }



}

