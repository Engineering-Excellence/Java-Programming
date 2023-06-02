/** main.js  */

import getType from "../images/getType.js"

/*function getType(data) {
	//return Object.prototype.toString.call(data)
	return Object.prototype.toString.call(data).slice(8, -1)
}*/

console.log(getType(123))
console.log(getType(false))
console.log(getType('douzone'))
console.log(getType([1, 2, 3, 4]))
console.log(getType({}))


console.log('-----------------------------')
console.log(typeof 'Hello world!')
console.log(typeof 123)
console.log(typeof 12.34)
console.log(typeof true)
console.log(typeof undefined)
console.log(typeof null)
console.log(typeof {})
console.log(typeof [])
console.log('-----------------------------')

console.log('Hello world!')
console.log(123)
console.log(12.34)
console.log(true)
console.log(undefined)
console.log(null)
console.log({})
console.log([])
