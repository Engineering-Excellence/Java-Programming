'use strict'

// 2. This code loads the IFrame Player API code asynchronously.
var tag = document.createElement('script')

tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0]
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag)

// 3. This function creates an <iframe> (and YouTube player)
//    after the API code downloads.
function onYouTubeIframeAPIReady() {
    new YT.Player('player', {
        height: '360',
        width: '640',
        videoId: 'FAV-bwxLdxo', // 유튜브 상에 있는 유튜브의 id 영상으로 띄운다.
        playerVars: {
            autoplay: true,
            loop: true,
            playlist: 'FAV-bwxLdxo'
        },
        events: {
            onReady: event => {
                event.target.mute() // 음소거
            }
        }
    });
}

