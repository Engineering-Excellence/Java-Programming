'use strict'

// 함수
/*
    function name(val1, val2, ...) {

    }
*/

// 화살표 함수
/*
    () => { }
*/
const double1 = x => x * 2
const multi = (x, y) => x * y
console.log('double:', double1(5))
console.log('multi:', multi(6, 7))

const doubleArrow = x => x * 5
console.log('doubleArrow:', doubleArrow(5))

console.log('*--------------------------------------------------')

const xy = 7

function double3() { // 함수 정의부
    console.log(xy * 2)
}

double3()    // 함수 호출

console.log('*--------------------------------------------------');  // 즉시 실행함수 전에 ; 반드시 쓸 것

// 즉시실행함수
(function square(x) {
    console.log(x * x)
}(2));

(function () {
    console.log(xy * 2)
}())

console.log('*--------------------------------------------------')

/*
    변수 유효범위
    var: 함수 레벨
    let, const: 블럭 레벨
 */

// var y = 789
function scope() {
    if (true) {
        var y = 123
        // let y = 123
        console.log(y)
    }
    console.log(y)
}

// console.log(y)

scope()

console.log('*--------------------------------------------------')

/*
    형변환
    참: true, {}. [], 1, 2, 'false', -12, '3.45', 12.34, ...
    거짓: false, '', null, undefined, 0, -0, NaN
 */
if (0) {
    console.log(0)
}
if (!0) {
    console.log('!0')
}
if ('false') {
    console.log("'false'")
}

const a = 1
const b = 1
console.log(a === b)
