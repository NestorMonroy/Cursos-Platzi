export { };

enum PhotoOrientation {
  Lanscape,
  Portrait,
  Squeare,
  Panorama
}

class Picture {
  //Propiedades
  id: number;
  title: string;
  orientation: PhotoOrientation;

  constructor(id: number,
    title: string,
    orientation: PhotoOrientation) {

    this.id = id;
    this.title = title;
    this.orientation = orientation;
  }

  // Comportamiento 
  toString() {
    return `[id: ${this.id}, 
            title: ${this.title}, 
            orientation: ${this.orientation}]
            `
  }

};


class Album {
  id: number;
  title: string;
  picture: Picture[];

  constructor(id: number, title: string) {
    this.id;
    this.title;
    this.picture = [];
  }

  addPicture(picture: Picture) {
    this.picture.push(picture);
  }
}


const album:Album = new Album(1,'Personal Picture');
const picture:Picture = new Picture(1, 'Nestor', PhotoOrientation.Portrait);
album.addPicture(picture);

console.log('album', album);
