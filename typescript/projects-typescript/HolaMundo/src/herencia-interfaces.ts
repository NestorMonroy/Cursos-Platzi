export { };

enum PhotoOrientation {
	Lanscape,
	Portrait,
	Squeare,
	Panorama
}

interface Entity {
	id: number;
	title: string;
}

interface Album extends Entity {
	//Copia de los atributos de Entity
	description: string;
}


interface Picture extends Entity {
	orientation: PhotoOrientation
}

const album: Album = {
	id: 1,
	title: "Example",
	description: "Example description"

}
console.log('album', album);

const picture: Picture = {
	id: 2,
	title: "Picture Family",
	orientation: PhotoOrientation.Lanscape
};
console.log('picture', picture);

let newPicture = {} as Picture ;
newPicture.id = 3;
newPicture.title = "Moon"

console.log('newPicture', newPicture);



