import React from 'react'

const HolaMundo = () => {
  const Hello = 'Hola Nestor';
  const isTrue = true;

  return(
    <div className="Hola">
      <h1> {Hello} </h1>
      <h2>Curso React </h2>
      <img src="https://arepa.s3.amazonaws.com/react.png" alt="React" />
      {isTrue ? <h4>Esto es verdadero </h4> : <h5>Soy Falso</h5> }
      {isTrue && <h4>Soy Vedero </h4>}

    </div>
  )
}

export default HolaMundo;