export { };

enum PhotoOrientation {
  Landscape,
  Portrait,
  Square,
  Panorama
}

class Picture {
  // Propiedades
  public id: number;
  public title: string;
  public orientation: PhotoOrientation;

  public constructor(id: number,
    title: string,
    orientation: PhotoOrientation) {
    this.id = id;
    this.title = title;
    this.orientation = orientation;
  }

  // Comportamiento
  public toString() {
    return `[id: ${this.id}, 
                 title: ${this.title}, 
                 orientation: ${this.orientation}]`;
  }
}

class Album {
  public id: number;
  public title: string;
  public pictures: Picture[];

  public constructor(id: number, title: string) {
    this.id = id;
    this.title = title;
    this.pictures = [];
  }

  public addPicture(picture: Picture) {
    this.pictures.push(picture);
  }
}

const album: Album = new Album(1, 'Personal Nestor');
const picture: Picture = new Picture(1, 'Home session', PhotoOrientation.Square);
album.addPicture(picture);
console.log('album', album);

// Accediendo a los miembros publicos
picture.id = 100; // public
picture.title = 'Another title'; // public
album.title = 'Personal Activities'; //public
console.log('album', album);
