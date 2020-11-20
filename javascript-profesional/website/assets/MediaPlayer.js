function MediaPlayer(config) {
	// this guarda un valor en la instancia
	this.media = config.el;
}

MediaPlayer.prototype.play = function() {
	this.media.play();
};

MediaPlayer.prototype.pause = function() {
	this.media.pause();
};

export default MediaPlayer