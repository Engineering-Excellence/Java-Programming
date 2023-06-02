'use strict'

const person = {
    firstName: 'DoYeon'
    , lastName: 'Lee'
    , getFullName: function () {
        return `${this.firstName} ${this.lastName}`
    }
    , setFirstName: function (data) {
        this.firstName = data;
    }
}

console.log(person)
console.log(person.lastName);
person.setFirstName('Yuna');
console.log(person.getFullName());
console.log(person)

const any = {
    firstName: 'Any'
    , lastName: 'Clarke'
    , getFullName: function () {
        return `${this.firstName} ${this.lastName}`
    }
    , setFirstName: function (data) {
        this.firstName = data;
    }
}

console.log(any);
console.log(any.firstName);
any.setFirstName('kimkim');
console.log(any.getFullName());

function User(first, last) {
    this.firstName = first
    this.lastName = last
    this.getFullName = function () {
        return `${this.firstName} ${this.lastName}`
    }
}

const saram = User('person', 'any');
console.log(saram.firstName)
console.log(User);

/*
    this
    일반(Normal) 함수는 호출 위치에서 this 정의
    화살표(Arrow) 함수는 자신이 선언된 함수 범위에서 this 정의
 */

/*
function User(name) {
    this.name = name
}

User.prototype.arrow = () => console.log(kyle.name)
User.prototype.func = function () {
    console.log(this.name)
}

const hello = {
    name: 'Hello',
    normal: () => console.log(hello.name)
}
const world = {
    name: 'World',
    normal: function () {
        console.log(this.name)
    }
}

const kyle = new User('Kyle')
hello.normal()
world.normal()
kyle.arrow()
kyle.func()*/
