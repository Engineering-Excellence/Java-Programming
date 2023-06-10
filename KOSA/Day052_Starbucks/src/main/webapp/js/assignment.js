'use strict'

new Swiper('.rabbit .swiper-container', {
    direction: 'horizontal',    // 수평 슬라이드
    autoplay: {
        delay: 5000 // 5초마다 슬라이드 변경
    },
    loop: true,
    slidesPerView: 3, // 한 번에 보여줄 슬라이드 개수
    // spaceBetween: 10,
    centeredSlides: true,
    navigation: {
        prevEl: 'header .swiper-prev',
        nextEl: 'header .swiper-next'
    }
})

// 이미지 클릭시 메인 띄우기
const imgs = document.querySelectorAll('img')
imgs.forEach(e => {
    e.addEventListener('click', img => {
        let src = img.target.getAttribute('src')
        console.log(src)
        document.querySelector('.main-image img').setAttribute('src', src)
    })
})