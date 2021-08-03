//import { Album, PhotoOrientation, Picture, User } from "./photo-app";

import { Album } from "./album";
import { PhotoOrientation } from "./photoOrientation";
import { Picture } from "./picture";
import { User } from "./user";

const user = new User(1,'loco00', 'Nestor', true);
console.log(user);
console.log('----');

const album = new Album(10, 'Pictures');
console.log('----');
console.log(album);
const picture = new Picture(1,'TypeScript Course', '2030-03', PhotoOrientation.Portrait) 
console.log(picture);
console.log('----');

user.addAlbum(album);
album.addPicture(picture);

console.log('user', user);
console.log('----');
user.removeAlbum(album);
console.log('user', user);

