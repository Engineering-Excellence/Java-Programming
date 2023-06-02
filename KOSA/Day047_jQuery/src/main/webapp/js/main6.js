'use strict'

/*
    Callback 함수
*/
function timeout(callback) {
    setTimeout(() => {
        console.log('Daebo!')
        callback()
    }, 3000)
}

timeout(() => console.log('Done!'))

console.log('--------------------------------------------------')

/*
    ★ 타이머 함수
    setTimeout(함수, 시간): 일정시간 후 함수 실행
    setInterval(함수, 시간): 일정시간 간격마다 함수 실행
    clearTimeout(함수, 시간): 설정된 setTimeout() 종료
    clearInterval(함수, 시간): 설정된 setInterval() 종료
*/
// const timer = setTimeout(() => console.log('Timer!'), 1000)
const timer = setInterval(() => console.log('Timer!'), 5000)
/*
    setTimeout(function () {
        console.log('Daebo!')
    }, 2000)
    setTimeout(() => console.log('Arrow!'), 3000)
*/

const h3El = document.querySelector('h3')
h3El.addEventListener('click', () => {
    // clearTimeout(timer)
    clearInterval(timer)
    alert('Clear!')
})

console.log('--------------------------------------------------')

// ★ Hoisting: 함수 선언부가 유효범위 최상단으로 끌어올려지는 현상(함수 표현식 형태에서는 호이스팅 불가)
const a = 7
method()    // 함수 호출
function method() { // 함수 정의부
    console.log(a * 2)
}

// method()
// const method = () => console.log(a * 3)  // 함수 표현식
// method()

console.log('--------------------------------------------------')
