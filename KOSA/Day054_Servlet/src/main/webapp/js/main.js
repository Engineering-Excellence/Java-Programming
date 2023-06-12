'use strict'

// ID 3자 이상, PW 4자 이상 15자 이하 유효성 검사
const validation = () => {
    let id = document.forms["form"]["id"];
    let pw = document.forms["form"]["pw"]

    const idRegExp = /^[a-zA-Z0-9]{3,10}$/
    const pwRegExp = /^[a-zA-Z0-9]{4,12}$/
    if (!idRegExp.test(id.value)) {
        alert('ID는 3자 이상 10자 이하로 입력해야 합니다.')
        id.value = ''
        id.focus()
        return false
    }
    if (!pwRegExp.test(pw.value)) {
        alert('PW는 4자 이상 12자 이하로 입력해야 합니다.')
        pw.select()
        return false
    }
    return true
}
