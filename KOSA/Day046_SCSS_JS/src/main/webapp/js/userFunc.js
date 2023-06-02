'use strict'

export default function getType(data) {
    return Object.prototype.toString.call(data).slice(8, -1)
}

export function userRandom() {
    return Math.floor(10 * Math.random())
}