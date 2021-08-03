export { };

enum PhotoOrientation {
  Landscape,
  Portrait,
  Square,
  Panorama
}


//SuperClase

abstract class Item {
  protected readonly _id: number;
  protected _title: string; // acceso intermedio para acceso a las subclases son protected 
  constructor(id: number, title: string) {
    this._id = id;
    this._title = title;
  }

  get id() {
    return this._id
  };

  // set id(id: number) {
  //   this._id = id;
  // };

  get title() {
    return this._title
  };

  set title(title: string) {
    this._title = title;
  };

}


class Picture extends Item {
  public static photoOrientation = PhotoOrientation; // Nuevo miembro a la clase

  private _orientation: PhotoOrientation;

  public constructor(id: number,
    title: string,
    orientation: PhotoOrientation) {
    super(id, title);
    this._orientation = orientation;
  }

  get orientation() {
    return this._orientation
  };

  set orientation(o: PhotoOrientation) {
    this._orientation = o;
  };

  public toString() {
    return `[_id: ${this._id}, 
                 _title: ${this._title}, 
                 orientation: ${this._orientation}]`;
  }
}

class Album extends Item {

  private pictures: Picture[];

  public constructor(id: number, title: string) {
    super(id, title); // Constructor de superclase
    this.pictures = [];
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


//picture.id = 100; // private, change with readonly
picture.title = 'Test title'; // private
album.title = 'Personal Activities'; //private
console.log('album', album);
console.log('-------------');
// const item = new Item(5, 'testTitle') // Error con abstract
// console.log('item', item);

//Probar el miembro statico de Picture
console.log('PhotoOrientation', Picture.photoOrientation.Portrait);

 