let httpRequest;
let result;
window.onload = function() {
    /* 통신에 사용 될 XMLHttpRequest 객체 정의 */
    httpRequest = new XMLHttpRequest();
    /* httpRequest의 readyState가 변화했을때 함수 실행 */
    httpRequest.onreadystatechange = () => {
        /* readyState가 Done이고 응답 값이 200일 때, 받아온 response로 name과 age를 그려줌 */
        if (httpRequest.readyState === XMLHttpRequest.DONE) {
                if (httpRequest.status === 200) {
                    result = httpRequest.response;
                    console.log(result);
                    // let jsonObj = JSON.parse(result);
                    // console.log(jsonObj);

                    // let jsonStr = JSON.stringify(result, null, 2);
                    // console.log(jsonStr);
                    // console.log(typeof jsonStr);

                        // const movie1 = result[0].;
                    parsing(result);
            } else {
                alert('Request Error!');
            }
        }
    };

    /* Get 방식으로 name 파라미터와 함께 요청 */
    httpRequest.open('GET', 'http://192.168.0.25:5000/ranking');
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

    //

    let key = [2,54,62,63,73,84,90,91,92];
    let rankingMovie = [];
    let keyNum = 0;

    for(let i=0; i<9; i++){
        // console.log(key[i]);
        keyNum = key[i];     //2, ok
        // console.log(keyNum);
        // console.log(movie[keyNum]);
        rankingMovie[i] = movie[keyNum];
        console.log(rankingMovie[i]);
    }

    let imgCount = 0;
    for(let i=0; i<9; i++){
        let showRanking = 'rankingImg' + (i+1);
        // console.log(showRanking);
        document.getElementById(showRanking).src = '../assets/img/movies/' + rankingMovie[i] + '.png';
        ++imgCount;
    }



}
//
// parsing();