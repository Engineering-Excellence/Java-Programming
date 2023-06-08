'use strict'

const numbers = [1, 2, 3, 4, 5]
const fruits = ['Apple', 'Banana', 'Cherry']

// -----------------------------------------------------------

let [x, y] = [10, 20]   // 구조분해할당
let [x1, y2, ...rest] = [10, 20, 3, 4, 5, 6, 7]

const [ff, g, h, i, j] = fruits
console.log(fruits) // ['Apple', 'Banana', 'Cherry']
console.log(...fruits)  // Apple Banana Cherry

console.log('***********************************************************')

/*
function toObject(xx, yy, zz) {
    return {
        xx: xx,
        yy: yy,
        zz: zz
    }
}
*/

/*
function toObject(xx, yy, zz) {
    return {
        xx,
        yy,
        zz: zz
    }
}
*/

const toObject = (xx, yy, ...zz) => ({xx, yy, zz})

console.log(toObject(...fruits))
// console.log(fruits[0], fruits[1], fruits[2])

console.log('***********************************************************')

const [, z] = fruits
console.log(ff.z)

console.log('-----------------------------------------------------------')

const Person = {
    name: 'Kyle',
    age: 99,
    email: 'anonym@seoul.kr',
    address: 'Busan'
}

const [] = []
const {name, age, email, address, phone} = Person
console.log(`userName: ${name}`)
console.log(`age: ${age}`)
console.log(`email: ${email}`)
console.log(address)
console.log(phone)  // undefined

// const {name, age} = Person    // 변수로 취급

console.log('-----------------------------------------------------------')

// keys()
const keys = Object.keys(Person)
console.log(keys)
console.log(Person['name'])
console.log(Person.name)

const values = keys.map(key => Person[key])
console.log(values)
/*
function Person {
    key1 = 'value',
        key2 = 222,
        method = function () {
        }
}

const Person = {
    key1: 'value',
    ley2: 222,
    method: function () {
    }
}
*/

console.log('-----------------------------------------------------------')

// splice(인덱스, 개수, 대체)
// numbers.splice(2)    // [2]부터 전부 지움
// numbers.splice(2, 2)    // [2], [3] 지움
numbers.splice(2, 0, 99)    // [2]부터 0개 지우고 99로 대체
console.log(numbers)
fruits.splice(2, 0, 'Orange')
console.log(fruits)

console.log('-----------------------------------------------------------')

// reverse()
numbers.reverse()
fruits.reverse()
console.log(numbers)
console.log(fruits)

console.log('-----------------------------------------------------------')

// push() & unshift(): 원본이 변경됨
numbers.push(99)
console.log(numbers)
numbers.unshift(50)
console.log(numbers)

console.log('-----------------------------------------------------------')

// includes()
const e = numbers.includes(3)
console.log(e)
const f = fruits.includes('Kyle')
console.log(f)

console.log('-----------------------------------------------------------')

// find() & findIndex()
const c = fruits.find(item => item.startsWith("C"))
console.log(c)
const d = fruits.findIndex(item => /^C/.test(item))
console.log(d)

console.log('-----------------------------------------------------------')

// .filter()
const a = numbers.map(num => {
    // console.log(num)
    return num < 3
})
console.log(a)

const b = numbers.filter(num => num < 3)
console.log(b)
console.log(numbers)
