/*
  no se usa fech (ECMA-6) ya que ya se usan promesas
*/
let XMLHttpRequest = require('xmlhttprequest').XMLHttpRequest;

function fetchData(url_api, callback) {
	let xhttp = new XMLHttpRequest();

	xhttp.open('GET', url_api, true);
	xhttp.onreadystatechange = function(event) {
		/*
      los estados 
      0: request no initialized (inicializado)
      1: server connection established (cargando)
      2: request received (ya se cargo)
      3: processing request (ya hay informacion)
      4: request finished (solicitud completa)
    */
		if (xhttp.readyState === 4) {
			if (xhttp.status === 200) {
				callback(null, JSON.parse(xhttp.responseText));
			} else {
				const error = new Error('Error' + url_api);
				return callback(error, null);
			}
		}
  };
  
  xhttp.send()
}

