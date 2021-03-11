import { Component } from 'react';


class App extends Component {
  constructor() {
    super();
    this.state = {
      usuarios: [
        {
          nombre: 'Nestor',
          correo: 'nestor@platzi.com',
          enlace: 'nestor.com'
        },
        {
          nombre: 'Joel',
          correo: 'joel@platzi.com',
          enlace: ''
        },
        {
          nombre: 'Otro',
          correo: 'info@platzi.com',
          enlace: 'platzi.com'
        }
      ]
    }
  }

  ponerFilas = () => this.state.usuarios.map((usuario) => (
    <tr>
      <td>
        {usuario.nombre}
      </td>
      <td>
        {usuario.correo}
      </td>
      <td>
        {usuario.enlace}
      </td>
    </tr>
  ));

  render() {
    return (
      <div className="margen">
        <table className="tabla">
          <thead>
            <tr>
              <th>
                Nombre
							</th>
              <th>
                Correo
							</th>
              <th>
                Enlace
							</th>
            </tr>
          </thead>
          <tbody>
            {this.ponerFilas()}
          </tbody>
        </table>
      </div>
    )
  }
};

export default App;