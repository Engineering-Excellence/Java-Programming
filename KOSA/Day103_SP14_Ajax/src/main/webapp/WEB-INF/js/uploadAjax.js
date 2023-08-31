'use strict'

$(() => {

    $('#uploadBtn').on('click', e => {
        let formData = new FormData()
        let inputFile = $("input[name='uploadFile']")
        let files = inputFile[0].files
        console.log(files)

        // add File Data to FormData
        for (const file of files) {
            formData.append('uploadFile', file)
        }

        let data = {
            title: $("input[name='title']").val(),
            content: $("input[name='content']").val(),
        }
        formData.append("info", new Blob([JSON.stringify(data)], {type: "application/json"}));

        $.ajax({
            url: '/uploadAjaxAction',
            processData: false,
            contentType: false,
            data: formData,
            type: 'POST',
            dataType: 'json',
            success: res => {
                console.log(res)
                alert('파일 업로드 성공')
            }/*,
            error: err => {
                console.error(err)
                alert('파일 업로드 실패')
            }*/
        })  // end of $.ajax
    })
})