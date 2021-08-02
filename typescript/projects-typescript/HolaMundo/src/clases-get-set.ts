export { };

enum PhotoOrientation {
  Landscape,
  Portrait,
  Square,
  Panorama
}


class Picture {

  private _id: number;
  private _title: string;
  private _orientation: PhotoOrientation;

  public constructor(id: number,
    title: string,
    orientation: PhotoOrientation) {
    this._id = id;
    this._title = title;
    this._orientation = orientation;
  }

  get id() {
    return this._id
  };

  set id(id: number) {
    this._id = id;
  };

  get title() {
    return this._title
  };

  set title(title: string) {
    this._title = title;
  };

  get orientation() {
    return this._orientation
  };

  set orientation(o: PhotoOrientation) {
    this._orientation = o;
  };


  // Comportamiento
  public toString() {
    return `[id: ${this._id}, 
                 title: ${this._title}, 
                 orientation: ${this._orientation}]`;
  }
}

class Album {
  private _id: number;
  private _title: string;
  private pictures: Picture[];

  public constructor(id: number, title: string) {
    this._id = id;
    this._title = title;
    this.pictures = [];
  }

  get id() {
    return this._id
  }

  set id(id: number) {
    this._id = id;
  }

  get title() {
    return this._title
  }

  set title(title: string) {
    this._title = title;
  }


  public addPicture(picture: Picture) {
    this.pictures.push(picture);
  }
}

const album: Album = new Album(1, 'Personal Pictures');
const picture: Picture = new Picture(1, 'Nestor session', PhotoOrientation.Square);
album.addPicture(picture);
console.log('-------------');
console.log('album', album);
console.log('-------------');
//Accediendo a los miembros publicos
console.log('picture.id', picture.id); // get id()
console.log('-------------');


picture.id = 100; // private
picture.title = 'Another title'; // private
album.title = 'Personal Activities'; //private
console.log('album', album);
