import React, { Component } from 'react'

//  Estructura de clase, tiene ciclo de vida , estado y eventos

class Stateful extends Component {
  constructor(props) {
    super(props)
  
    this.state = {
      hello: 'Hola nestor'
    }
  
  }
  
  render() { 
    return (  
      <div> {this.state.hello} </div>
    );
  }
}
 
export default Stateful;