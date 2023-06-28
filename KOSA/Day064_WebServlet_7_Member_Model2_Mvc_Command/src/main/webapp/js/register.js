'use strict'

function checkId(idValue) {
    location.href = './memo/id?id=' + idValue
}

function deleteMemo(idValue) {
    location.href = './memo/delete?id=' + idValue
}

function updateMemo(idValue) {
    location.href = './memo/update?id=' + idValue
}
