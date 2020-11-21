import MediaPlayer from './MediaPlayer.js'
import AutoPlay from './plugins/Autoplay.js'

const video = document.querySelector('video');
const button = document.querySelector('button');

const player = new MediaPlayer({ el: video, plugins:[
	//new AutoPlay()
] });

button.onclick = () => {
	player.media.paused ? player.media.play() : player.media.pause();
};