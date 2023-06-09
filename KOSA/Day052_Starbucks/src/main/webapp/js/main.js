'use strict'

// 검색창 제어 - 요소(.search)
const searchEl = document.querySelector('.search')
const searchInputEl = searchEl.querySelector('input')

// 검색창 클릭 이벤트 발생시 실행
searchEl.addEventListener('click', () => {
    searchInputEl.focus()
})

// 검색창 요소 내부 실제 input 요소에 포커스 되면 실행할 내용
searchInputEl.addEventListener('focus', () => {
    searchEl.classList.add('focused')
    searchInputEl.setAttribute('placeholder', '검색어 입력')
})

// 포커스 해제시(블러) 실행
searchInputEl.addEventListener('blur', () => {
    searchEl.classList.remove('focused')
    searchInputEl.setAttribute('placeholder', '')
})

// 페이지 스크롤에 따른 요소 제어 - badges 제어
const badgeEl = document.querySelector('header .badges')
const toTopEl = document.querySelector('#to-top')

// 스크롤이 지나치게 자주 발생하는 것을 조절(_.throttle)
window.addEventListener('scroll', _.throttle(() => {
    if (window.scrollY > 500) {
        gsap.to(badgeEl, .6, {
            opacity: 0,  // badge 요소 숨기기
            display: 'none'
        })
        gsap.to(toTopEl, .2, {
            x: 0  // 상단으로 스크롤 버튼 보이기
        })
    } else {

        gsap.to(badgeEl, .6, {
            opacity: 1,  // badge 요소 보이기
            display: 'block'
        })
        gsap.to(toTopEl, .2, {
            x: 100  // 상단으로 스크롤 버튼 숨기기
        })
    }
}, 300))

// TOP 클릭시
toTopEl.addEventListener('click', () => {
    gsap.to(window, .7, {
        scrollTo: 0
    })
})

// 순서대로 나타내는 기능 - 나타낼 요소 찾기 (.fade-in)
const fadeEls = document.querySelectorAll('.visual .fade-in')
fadeEls.forEach((fadeEl, index) => {    // 이미지를 하나씩 반복해서 처리
    gsap.to(fadeEl, 1, {
        delay: (index + 1) * .7,
        opacity: 1
    })
})

// 슬라이드 요소 관리
new Swiper('.notice-line .swiper-container', {
    direction: 'vertical',  // 수직 슬라이드
    autoplay: true, // 자동 재생
    loop: true  // 반복 재생
})

new Swiper('.promotion .swiper-container', {
    direction: 'horizontal',    // 수평 슬라이드
    autoplay: {
        delay: 5000 // 5초마다 슬라이드 변경
    },
    loop: true,
    slidesPerView: 3, // 한 번에 보여줄 슬라이드 개수
    spaceBetween: 10,
    centeredSlides: true,
    pagination: {
        el: '.promotion .swiper-pagination',
        clickable: true
    }
})

new Swiper('.awards .swiper-container', {
    autoplay: true,
    loop: true,
    spaceBetween: 30,
    slidesPerView: 5,
    navigation: {
        prevEl: '.awards .swiper-prev',
        nextEl: '.awards .swiper-next'
    }

})

const promotionEl = document.querySelector('.promotion')
const promotionToggleBtn = document.querySelector('.toggle-promotion')
let isHidePromotion = false
promotionToggleBtn.addEventListener('click', () => {
    isHidePromotion = !isHidePromotion
    if (isHidePromotion) {
        promotionEl.classList.add('hide')
    } else {
        promotionEl.classList.remove('hide')
    }
})
