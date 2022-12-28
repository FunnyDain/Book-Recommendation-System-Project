let httpRequest;
let result;
let mbti = document.getElementById('mbtiSession').innerText;
let mbtiSub = mbti.substring(0,2);
let mbtiUrl;
let key;



window.onload = function() {
    /* 통신에 사용 될 XMLHttpRequest 객체 정의 */
    httpRequest = new XMLHttpRequest();
    /* httpRequest의 readyState가 변화했을때 함수 실행 */
    httpRequest.onreadystatechange = () => {
        /* readyState가 Done이고 응답 값이 200일 때, 받아온 response로 name과 age를 그려줌 */
        if (httpRequest.readyState === XMLHttpRequest.DONE) {
            if (httpRequest.status === 200) {
                // console.log(mbti);
                // console.log(mbtiSub);
                result = httpRequest.response;
                console.log(result);
                parsing(result);
            } else {
                alert('Request Error!');
            }
        }
    };

    switch (mbtiSub){
        case 'IS':
            mbtiUrl = 'http://192.168.0.37:5000/IS';
            key = [10,15,22,37,45,51,80,137];
            break;
        case 'ES':
            mbtiUrl = 'http://192.168.0.37:5000/ES';
            key = [2,3,7,11,12,13,23,24];
            break;
        case 'IN':
            mbtiUrl = 'http://192.168.0.37:5000/IN';
            key = [29,33,38,39,40,93,99,108];
            break;
        case 'EN':
            mbtiUrl = 'http://192.168.0.37:5000/EN';
            key = [6,19,21,30,31,42,48,55];
            break;
    }

    /* Get 방식으로 name 파라미터와 함께 요청 */
    httpRequest.open('GET', mbtiUrl);
    /* Response Type을 Json으로 사전 정의 */
    httpRequest.responseType = "json";
    /* 정의된 서버에 요청을 전송 */
    httpRequest.send();
}           //end function();





function parsing(result){
    const movie = result.영화제목;
    console.log(movie);
    console.log(typeof movie);
    // console.log(movie["2"]);


    // let key = [10,15,22,37,45,51,80,137];
    let mbtiMovie = [];
    let keyNum = 0;
    //
    for(let i=0; i<8; i++){
        // console.log(key[i]);
        keyNum = key[i];     //2, ok
        // console.log(keyNum);
        // console.log(movie[keyNum]);
        mbtiMovie[i] = movie[keyNum];
        console.log(mbtiMovie[i]);
    }

    let imgCount = 0;
    for(let i=0; i<8; i++){
        let showMbtiImg = 'mbtiImg' + (i+1);
        let showMBtiMovie = 'mbtiMovieName' + (i+1);
        // console.log(showRanking);
        document.getElementById(showMbtiImg).src = '../assets/img/movies/' + mbtiMovie[i] + '.png';
        document.getElementById(showMBtiMovie).innerText = mbtiMovie[i];
        ++imgCount;
    }



}

// parsing();