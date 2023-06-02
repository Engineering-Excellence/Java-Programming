'use strict'

// 찾은 요소들 반복해서 함수 실행 - 익명 함수 추가
// forEach(function(요소값, 인덱스, 전체 요소))
const boxEls = document.querySelectorAll('.box')
boxEls.forEach((item, index) => {
    item.classList.add(`order-${index + 1}`)
    console.log(index, item)
})

// HTML 요소(Element) 1개 검색/찾기
const boxEl = document.querySelector('.box')
console.log(boxEl)

// HTML 요소에 적용할 수 있는 메서드
// 인수(Arguments) 추가
// addEventListener('이벤트', 함수)
boxEl.addEventListener('click', () => {
    if (!boxEl.classList.contains('active')) {
        alert('Active!')
        boxEl.classList.add('active')
        console.log(boxEl.classList.contains('active'))
    } else {
        alert('Dective!')
        boxEl.classList.remove('active')
        console.log(boxEl.classList.contains('active'))
    }
})

let isShow = true
let checked = false

if (isShow) {
    console.log('Show!')
}

if (checked) {
    console.log('Checked!')
} else {
    console.log('Hide?')
}
