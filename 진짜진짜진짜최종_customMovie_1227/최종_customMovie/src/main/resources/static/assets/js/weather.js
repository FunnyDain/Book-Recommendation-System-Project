const weather = document.querySelector('.js-weather');

const API_KEY = '334d14b3f03474616fa71493c402068e';
const COORDS = 'coords';

//temparature(온도), place(장소)를 각각 JSON Data로 설정하고,
//weather innerText = __에 $로 각각 argumentation(인자화)해서 HTML에 출력함

function getWeather(lat, lon) {
    //js(새로고침없이 데이터 가져오기 가능)에서 특정 url을 호출해서 데이터를 얻는 법: fetch
    fetch(
        //openweather의 api호출 url
        `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${API_KEY}&units=metric` //units=metric : temparature 섭씨 단위로 바꿔줌
    )
        //then : 데이터가 완전히 넘어왔을 때, 함수를 호출
        .then(function (response) {
            return response.json();
        })
        .then(function (json) {
            console.log(json);
            //url검색으로 확인
            // const main = json.main;
            const temparature = json.main.temp;
            const place = json.name;
            const weatherdes = json.weather[0].description;
            const humidity = json.main.humidity;
            const wind = json.wind.speed;

            document.getElementById('todayWeather').innerHTML = `${weatherdes}`;
            document.getElementById('geo').innerHTML = `현재 위치 | ${place}`;
            document.getElementById('weatherTemp').innerHTML = `${temparature}&#8451;`;
            document.getElementById('weatherDes').innerHTML = `현재 날씨는 ${weatherdes}&#8451; 인 상태입니다.`;
            document.getElementById('weatherHum').innerHTML = `체감 습도 ${humidity}&#8451;`;
            document.getElementById('weatherWind').innerHTML = `바람은 ${wind}&#8451;`;



            // document.getElementById('name').innerHTML = `날씨: ${weatherdes} 온도: ${temparature} @ 장소 : ${place}`;
            // document.getElementById('weatherImg').innerHTML ="<i class='fa-solid fa-poo-storm'></i>";



            //중복없이 랜덤 숫자 뽑는 함수
            //every()함수를 사용, 모든 조건을 만족하면 true, 하나라도 만족하지 않으면 false
            const lotto = [];
            function lottoNum() {
                function makeNum() {
                    if (lotto.length < 6) {
                        let n = Math.floor(Math.random() * 45) + 1;
                        if (notSame(n)) {
                            lotto.push(n);
                        }
                        makeNum();
                    }
                    function notSame(n) {
                        return lotto.every(e => n !== e);
                    }
                }
                makeNum();
                return lotto;
            }
            lottoNum();

            if (weatherdes.includes('clear')) {
                document.getElementById('weatherImg').innerHTML ="<i class=\"fa-sharp fa-solid fa-sun\"></i>";
                console.log('맑다.');
                for (let i = 0; i < 6; i++) {
                    //여름날씨 일경우
                    if (temparature > 28) {
                        let showImg = 'img' + (i+1);
                        console.log(showImg);
                        document.getElementById(showImg).src = '../assets/img/weather/hot/movie' + lotto[i] + '.png';
                    } else {
                        let showImg = 'img' + (i+1);
                        console.log(showImg);
                        document.getElementById(showImg).src = '../assets/img/weather/sunny/movie' + lotto[i] + '.png';
                    }
                }
            } else if (weatherdes.includes('snow')) {
                document.getElementById('weatherImg').innerHTML ="<i class='fa-solid fa-snowflake'></i>";
                console.log('눈이다.');
                for(let i=0; i<6; i++){
                    let showImg = 'img' + (i+1);
                    console.log(showImg);
                    document.getElementById(showImg).src = '../assets/img/weather/snow/movie' + lotto[i] + '.png';
                }
            } else if (weatherdes.includes('rain')||weatherdes.includes('Rain')||weatherdes.includes('Thunderstorm')) {
                for(let i=0; i<6; i++){
                    let showImg = 'img' + (i+1);
                    console.log(showImg);
                    document.getElementById(showImg).src = '../assets/img/weather/rain/movie' + lotto[i] + '.png';
                }
                if(weatherdes.includes('Thunderstorm')){
                    document.getElementById('weatherImg').innerHTML ="<i class='fa-solid fa-poo-storm'></i>";
                    console.log('태풍이다.');
                }else{
                    document.getElementById('weatherImg').innerHTML ="<i class='fa-solid fa-umbrella'></i>";
                    console.log('비가 내린다.');
                }
            } else if(weatherdes.includes('clouds') || weatherdes.includes('mist')){
                for(let i=0; i<6; i++){
                    let showImg = 'img' + (i+1);
                    console.log(showImg);
                    document.getElementById(showImg).src = '../assets/img/weather/rain/movie' + lotto[i] + '.png';
                }
                if(weatherdes.includes('clouds')){
                    document.getElementById('weatherImg').innerHTML ="<i class='fa-solid fa-cloud'></i>";
                    console.log('흐리다.');

                }else{
                    document.getElementById('weatherImg').innerHTML ="<i class='fa-solid fa-cloud-fog'></i>";
                    console.log('안개낌.');
                }
            }

        });
}

function saveCoords(coordsObj) {
    //localStorage.setItem("key",value) : key에 데이터 쓰기
    //JSON.stringify : javascript값이나 객체를 json문자열로 변환
    localStorage.setItem(COORDS, JSON.stringify(coordsObj));
}

function handleGeoSuccess(position) {
    console.log(position); //위도,경도 확인
    const latitude = position.coords.latitude; //위도값
    const longitude = position.coords.longitude; //경도값
    // 객체 생성
    const coordsObj = {
        latitude, //latitude = latitude
        longitude,
    };
    saveCoords(coordsObj);
    getWeather(latitude, longitude);
}

function handleGeoError(position) {
    console.log("Can't access geo location");
}
/* 좌표를 요청하는 함수 */
function askForcoords() {
    //navigator : window 내부 객체중 하나
    //getCurrentPosition은 처음인자로 GPS 위치 동의시 실행할 함수, 에러, 그 외 옵션을 인자로 받는다.
    navigator.geolocation.getCurrentPosition(handleGeoSuccess, handleGeoError);
}

function loadCoords() {
    //데이터를 서버가 아닌 유실되도 무방한 데이터라면 브라우저에 저장하는 localStorage, 세션이 끝나더라도 데이터가 지워지지 않음
    //getItem("key"): 키로부터 데이터 읽기
    const loadedCoords = localStorage.getItem(COORDS);
    if (loadedCoords == null) {
        askForcoords();
    } else {
        //좌표가 있다면,
        //JSON.parse() : jason문자열의 구문을 분석하고, 그 결과에서 javascript값이나 객체 생성
        const parseCoords = JSON.parse(loadedCoords);
        console.log(parseCoords);
        getWeather(parseCoords.latitude, parseCoords.longitude);
    }
}

function init() {
    loadCoords();
}

init();
