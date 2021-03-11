const App = () => {

  const ponerFilas = () => [
    <tr>
      <td>
        Nestor
			</td>
      <td>
        nestor@abc.com
			</td>
      <td>
        Nestor.com
			</td>
    </tr>,
    <tr>
      <td>
        Joel
			</td>
      <td>
        joel@abc.com
			</td>
      <td>
        Joel.com
			</td>
    </tr>
  ];

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
          {ponerFilas()}
        </tbody>
      </table>
    </div>
  )
};

export default App;