import { connect } from 'react-redux';

const Tabla = (props) => {
  // Cuando hay una funcion en un componente funcional , debe de empezar con const, aqui no se usa this
	const ponerFilas = () => props.usuarios.map((usuario) => (
		<tr key={ usuario.id }>
			<td>
				{ usuario.name }
			</td>
			<td>
				{ usuario.email }
			</td>
			<td>
				{ usuario.website }
			</td>
		</tr>
	));

	return (
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
				{ ponerFilas() }
			</tbody>
		</table>
	)
}

const mapStateToProps = (reducers) => {
	return reducers.usuariosReducer;
};

export default connect(mapStateToProps)(Tabla);