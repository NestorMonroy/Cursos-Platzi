import MediaPlayer from './MediaPlayer.js';
import AutoPlay from './plugins/AutoPlay.js';
import AutoPause from './plugins/AutoPause.js';

const video = document.querySelector('video');
const player = new MediaPlayer({
  el: video,
  plugins: [
    new AutoPlay(), 
    new AutoPause()
  ],
});

const playButton = document.querySelector('#playButton');
playButton.onclick = () => player.togglePlay();

const muteButton = document.querySelector('#muteButton');
muteButton.onclick = () => {
  if (player.media.muted) {
    player.unmute();
  } else {
    player.mute();
  }
};

/* 

  Los services workers se instalan, el navegador lo va a instalar en la computadora del usuario, no es lo mismo que una aplicación, 
  pero si va a vivir dentro del navegador, entonces cada vez que nostros hagamos cambios hay que volver a instalarlos, 
  esto va suceder cuando el usuario este usando la aplicación en producción pero cuando estamos en desarrollo queremos que esto suceda rápido, no con la lentitud que pueda suceder en producción. 
  Para hacerlo hay que activar updated on reload en las devtools 
  
*/
if ('serviceWorker' in navigator) {
  navigator.serviceWorker.register('/sw.js').catch(error => {
    console.log(error.message);
  });
}
