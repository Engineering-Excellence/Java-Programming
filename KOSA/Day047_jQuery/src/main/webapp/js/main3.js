/** main3.js */

// 제어문 - if , for, while,.....

/*
let dan = prompt('dan input : ')
console.log(dan)
*/
console.log('****************************')
const ulEl = document.querySelector('ul')  //  #idName,  .className
console.log(ulEl)

for (let i = 0; i < 10; i += 1) {
    const li = document.createElement('li')
    li.textContent = `list-${i + 1}`   // 'list-' + (i+1)
    if (i % 2 === 0) {
        li.addEventListener('click', function () {
            console.log(li.textContent)
        })
    }
    ulEl.appendChild(li)
}

// 선택자.addEventListener(이벤트명, 해야할일)  
console.log('****************************')

// selector.addEventListener(eventName, function(){})

for (let i = 0; i < 3; i += 1) {
    const li = document.createElement('li')
    li.textContent = `list-${i + 1}`   // 'list-' + (i+1)
    ulEl.appendChild(li)
}

//3. for
for (let i = 0; i < 3; i += 1) {
    console.log(i)
}


console.log('=================')

const x = Math.floor(Math.random() * 10)   // 난수 

console.log(x)

//2. switch ~ case 
switch (x) {
    case 0:
        console.log('x is 0')
        break;
    case 2:
        console.log('x is 2')
        break;
    case 5:
        console.log('x is 5')
        break;
    default:
        console.log('reset......', x)
}


console.log('=================')

//1. if~ else

if (x === 0) {
    console.log('x is 0')
} else if (x === 2) {
    console.log('x is 2')
} else {
    console.log('reset......', x)
}