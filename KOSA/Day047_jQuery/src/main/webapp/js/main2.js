/**  main2.js */
// Operator 

//4. 삼항(조건) 연산자
const g = 1 < 2

if (g) {
    console.log('참')
} else {
    console.log('거짓')
}

console.log(g ? '참' : '거짓')

//3. 논리 연산자
const d = 1 === 1
const e = 'AB' === 'AB'
const f = true

console.log(d)
console.log(e)
console.log(f)
console.log('--------------------')

console.log('&&: ', d && e && f)
console.log('&&: ', d && e && f && false)

console.log('||: ', d || e || f)
console.log('||: ', d || e || f || false)
console.log('-==============')
//2. 비교연산자
const b = 1
const c = '1'
console.log(c == b)   // 일치
console.log(c === b)
console.log(c != b)  //
console.log(c !== b)
console.log(3 > 5)

function isEqual(x, y) {
    //return  x === y
    return x !== y
}

console.log('--------------------')
console.log(isEqual(1, 1))
console.log(isEqual(1, '2'))
console.log(isEqual(1, 3))
console.log(isEqual(1, '1'))  //

console.log('--------------------')
console.log(isEqual(1, 1))
console.log(isEqual(1, '2'))
console.log(isEqual(1, 3))
console.log(isEqual(1, '1'))  //

// 1. 산술연산자
let a = 2
a += 1  //a = a + 1
console.log(a)

console.log('main2.js')
console.log(1 + 2)
console.log(5 - 7)
console.log(3 * 4)
console.log(10 / 2)
console.log(7 % 5)