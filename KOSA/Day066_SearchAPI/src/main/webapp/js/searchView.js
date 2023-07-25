'use strict'

$(() => {
    console.log('searchView.js')
    $('#searchBtn').click(() => {
        console.log('AJAX')
        $.ajax({
            url: '../NaverSearchAPI.do', // 요청 URL
            type: 'GET',    // HTTP 메서드
            data: { // 매개변수로 전달할 데이터
                keyword: $('#keyword').val(),   // 검색어
                startNum: $('#startNum option:selected').val()   // 검색 시작 위치 
            },
            dataType: 'json',   // 응답 데이터 형식
            success: sucFuncJson,   // 요청 성공시 호출할 메서드 설정
            error: errFunc  // 요청 실패시 호출할 메서드 설정
        })
    })
})

// 검색 성공시 결과 화면 출력
function sucFuncJson(data) {
    console.log('suncFuncJson()')

    let str = '';
    $.each(data.items, (index, item) => {
        str += `<ul>
                    <li>${index + 1}</li>
                    <li>${item.title}</li>
                    <li>${item.description}</li>
                    <li>${item.bloggername}</li>
                    <li>${item.bloggerlink}</li>
                    <li>${item.postdate}</li>
                    <li><a href="${item.link}" target="_blank">바로가기</a></li>
                </ul>`
    })
    $('#searchResult').html(str)
}

// 실패시 경고창 출력
function errFunc(e) {
    console.log('errFunc()')
    alert(`실패: ${e.status}`)
}