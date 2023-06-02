'use strict'

import getType, {userRandom} from "./userFunc.js";

// 할당 연산
let x = 2;
x += 1
console.log(x)

// 비교 연산자
const y = 1
const z = '1'
console.log(y == z)
console.log(y === z)

// 논리 연산자
const c = 1 === 1
const d = 'AB' === 'AB'
const e = true
console.log(c)
console.log(d)
console.log(e)
console.log('&&:', c && d && e) // and
console.log('||:', c || d || e) // or

// 삼항 연산자
const f = 1 < 2
if (f) console.log('참')
else console.log('거짓')
console.log(f ? 'yes' : 'no')

console.log(typeof 'Hello, world!')
console.log(typeof 123)
console.log(typeof true)
console.log(typeof null)
console.log(typeof undefined)
console.log(typeof {})
console.log(typeof [])
console.log(typeof function () {
})
console.log(typeof Symbol())
console.log(typeof BigInt(123))
console.log(typeof new Date())
console.log(typeof new Error())
console.log(typeof new Set())
console.log(typeof new Map())
console.log(getType('Hello, world!'))

// 랜덤
console.log(10 * Math.random())
const func = userRandom()
console.log(func === 0 ? 'func === 0' : func === 9 ? 'func === 9' : 'rest')

const str = 'Daebo!'
/*
    split(): 문자를 인수 기준으로 쪼개서 배열로 반환
    reverse(): 배열 뒤집기
    slice(): 자르기
    join(): 배열을 인수 기준으로 문자로 병합해서 반환
*/

const boxEl = document.querySelector('.box')
console.log(boxEl)

// Getter
console.log(boxEl.textContent)

// Setter
boxEl.textContent = 'Hello, world!'
console.log(boxEl.textContent)
