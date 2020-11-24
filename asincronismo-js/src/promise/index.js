/* Promise : algo va a suceder  */

const somethingWillHappen = () => {
	return new Promise((resolve, reject) => {
		if (false) {
			resolve('hey :)');
		} else {
			reject('ups :(');
		}
	});
};

somethingWillHappen().then((response) => console.log(response)).catch((err) => console.log(err));

const somethingWillHappen2 = () => {
	return new Promise((resolve, reject) => {
		if (true) {
			setTimeout(() => {
				resolve('hey2 :)');
			}, 2000);
		}else {
      //const error = new Error('ups2 :(')
      //reject(error)
      reject('ups2 :(');
    }
	});
};


somethingWillHappen2()
  .then(response => console.log(response))
  .catch(err => console.error(err))

// llamado de multiples promesas se rechaza si  cualquiera de las dos es rechazada
Promise.all([somethingWillHappen(), somethingWillHappen2()])
  .then(response => console.log('Array of results', response))
  .catch(err => {console.error(err)})