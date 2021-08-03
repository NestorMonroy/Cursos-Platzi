// Orientacion para Fotografias
// const landScape = 0;
// const portrait = 1;
// const squeare = 2;
// const panorama = 3;


enum PhotoOrientation {
    Lanscape = 0, // 0
    Portrait = 1 , // 1
    Squeare = 2 , // 2
    Panorama = 3// 3
}

const landScape: PhotoOrientation = PhotoOrientation.Lanscape;
console.log('Lanscape', landScape);// genera los indices

console.log('Lanscape', PhotoOrientation[landScape]);

// Siempre valores consecutivos

enum PictureOrientation {
    Lanscape = 10, // 10
    Portrait, // 11
    Squeare, // 12
    Panorama// 33
}


console.log('Portrait', PictureOrientation.Portrait);

// Se pueden considerar claves, los enums se pueden personalizar, para que no tome los valores consecutivos
enum Country {
    Bolivia = 'bol',
    Colombia = 'col',
    Mexico ='mex',
    EEUU = 'usa',
    Espana = 'esp'
}

const country: Country = Country.Colombia;
console.log('Colombia', country);
