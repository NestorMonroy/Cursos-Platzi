export { };
// Funcion para mostrar una Fotografia

enum PhotoOrientation {
    Lanscape,
    Portrait,
    Squeare,
    Panorama
}

interface Picture {
    title: string,
    date: string,
    orientation: PhotoOrientation
}

function showPicture(picture: Picture) {
    console.log(`[title: ${picture.title},
                    date: ${picture.date},
                    orientation: ${picture.orientation}]`);

}

let myPicture = {
    title: 'Test Title',
    date: '2020-03-05',
    orientation: PhotoOrientation.Panorama
}

showPicture(myPicture);
showPicture({
    title: 'Test Title',
    date: '2020-03',
    orientation: PhotoOrientation.Squeare,
    //extra: 'Test' error
})


interface PictureConfig {
    title?: string,
    date?: string,
    orientation?: PhotoOrientation
}

function generatePicture(config: PictureConfig) {
    const pic = { title: 'Default', date: '2020-03' };

    if (config.title) {
        pic.title = config.title
    }if (config.date){
        pic.date = config.date
    }

    return pic
}

let picture = generatePicture({});
console.log('picture', picture);
picture = generatePicture({title:'Travel Pict'})
console.log('picture', picture);
picture = generatePicture({date:'2021-05'});
console.log('picture', picture);

// Atributos de solo lectura
// Interfaz: Usuario

interface User{
    readonly id:number, // solo lectura
    userName:string,
    isPro:boolean
}


let user: User;

user = {
    id:1,
    userName:'Example',
    isPro:true  
}
console.log('user', user);
user.userName ='Modificado'
// user.id = 20; // Error
console.log('user', user);




