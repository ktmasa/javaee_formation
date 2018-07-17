$(document).ready(function() {
    //var mavideo = $("#mavideo");
    var mavideo = document.getElementById("mavideo");
    var play =$("#play");
    var stop = $("#stop");
    var duree =$("#duree");
    var readyToPlay = false;

    stop.click(function() {
        mavideo.pause();
        mavideo.currentTime = 0;
    });

    play.click(function() {
        // la video est elle correctement chargée?
        if (readyToPlay) {
            // la vidéo est elle en pause ?
            if (mavideo.paused) {
                // la lecture est elle finie ?
                if (mavideo.ended) {
                    // rembobiner la vidéo
                    mavideo.currentTime = 0;
                }
                // lancer la lecture
                mavideo.play();
                play.empty().append("pause");
            }
            else {
                // la video était en cours de lecture
                // la mettre en pause
                mavideo.pause();
                play.empty().append("play");
            }
        }
    });

    // indiquer/surveiller le chargement de la video
    if (mavideo.readyState > 0) {
        readyToPlay = true;
    }
    else {
        // etre prévenu quand la vidéo est prete
        mavideo.addEventListener('loadedmetadata', function() {
            readyToPlay = true;
        });
    }
    // evenement quand le "curseur" de la video bouge
    mavideo.addEventListener("timeupdate", function() {
        duree.empty().append("time: " +mavideo.currentTime);
    });
});