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
