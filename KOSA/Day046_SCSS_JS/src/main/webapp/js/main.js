'use strict'

console.log(new Date())
console.log(new Date('2023-05-30').getDay())
console.log(new Date('2023-05-30').getFullYear())
console.log(new Date('2023-06-03').getDay())    // 일요일:0 ~ 토요일: 6

// string(문자 데이터): 따옴표 사용.
let myName = 'Kyle'
let email = 'anonym@anon.com'
console.log(myName, email)
// let hap = 'Hello, my name is ' + myName + '!'
let hap = `Hello, my name is ${myName}! Contact ${email}`
console.log(hap)

// number(숫자 데이터): 정수 및 부동소수점 숫자, ...
var num = 10.0
console.log(`num = ${num}`)

let opacity = 1.34
console.log(opacity)

// boolean(논리 데이터): true, false.
let checked = true
let isShow = false
console.log(checked)
console.log(isShow)

// undefined: 값이 할당되지 않은 상태.
let undef   //
var obj = {pass: 1234, pwd: '1234'}

console.log(undef)  // undefined
console.log(obj.pass)
console.log(obj.pwd)
console.log(obj.id) // undefined

// null: 어떤 값이 의도적으로 비어있음을 의미.
let empty = null
console.log(empty)  // null

// object(객체 데이터): 여러 데이터를 {key:value} 형태로 저장.
let user = {
    // key:value
    name: 'Kyle',
    age: 99,
    isValid: true
}
console.log(user)
console.log(user.name)
console.log(user.age)
console.log(user.isValid)

// array(배열 데이터): 여러 데이터를 순차적으로 저장.
let fruits = ['Apple', 'Banana', 'Cherry']
console.log(fruits)
for (const fruit of fruits) {
    console.log(fruit)
}

// 변수 선언 - 재할당 가능
let a = 2
let b = 5
console.log(a + b)
console.log(a - b)
console.log(a * b)
console.log(a / b)

a = 12
console.log(a)
b = 99
console.log(b)

// 변수 선언 - 재할당 불가
const x = 15
console.log(x)
// x = 9878 // 재할당 불가

// 예약어
// let this = 'Kyle'    // 예약어(keyword)는 변수로 사용 불가

// 함수 선언
function myFunc() { // 함수 선언부(정의부)
    // 실행 코드
    console.log('myFunc() 실행')
}

// 함수 호출
myFunc()

// return type function
function returnFunc() {
    return 'returnFunc() 반환 문자열'
}

let call = returnFunc()
console.log(call)

function sum(x, y) {    // x, y는 매개변수(parameter)
    return x + y
}

// 재사용
let c = sum(1, 2)
let d = sum(7, 12)
let e = sum(2, 4)
console.log(c, d, e)

// 기명(이름이 있는) 함수
function hello() {
    console.log('Hello, ')
}

// 익명(이름이 없는) 함수
let anonym = () => console.log("world!")

// 함수 호출
hello()
anonym()

// 객체 데이터
const person = {
    name: 'Kyle',
    age: 99,
    // Method
    // getName: () => this.name // 익명 함수에서는 this 사용 불가!!
    getName: function () {
        return this.name
    },
    getAge: function () {
        return this.age
    },
    setName: function (name) {
        this.name = name
    },
    setAge: function (age) {
        this.age = age
    }
}

const hisName = person.getName()
console.log(hisName)
console.log(person.getAge())
