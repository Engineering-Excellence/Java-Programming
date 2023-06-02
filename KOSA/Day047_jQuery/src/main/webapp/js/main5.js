'use strict'

// 함수
const arrowFunc2 = () => {
    return {name: 'Kyle', age: 99}
}
console.log('arrowFunc2:', arrowFunc2)
console.log('arrowFunc2:', arrowFunc2.name)

console.log('--------------------------------------------------')

const arrowFunc = () => [1, 2, 3]
console.log('arrowFunc:', arrowFunc)

console.log('--------------------------------------------------')

const sum11 = () => console.log('Hello, world!')
sum11()

console.log('--------------------------------------------------')
const sum10 = () => 1000
console.log('sum10:', sum10)

console.log('--------------------------------------------------')

const sum9 = x => x + 500
console.log('sum9 =', sum9(5))

console.log('--------------------------------------------------')

function sum4() {
    console.log(arguments)
    return arguments[0]
}

sum4()
console.log(sum4(100, 7, 3))

console.log('--------------------------------------------------')

const sum3 = (x, y) => x + y
console.log('sum3 =', sum3(10, 20))

console.log('--------------------------------------------------')

function sum2(x, y) {
    return x + y
}

const a = sum2(10, 20)
const b = sum2(5, 10)
console.log(`a = ${a}, b = ${b}`)

console.log('--------------------------------------------------')

function sum(x, y) {
    console.log(x + y)
}

sum(1, 3)
sum(5, 7)
