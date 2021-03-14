import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import '../assets/styles/components/Player.scss';
import NotFound from '../containers/NotFound';

const Player = () => {

  return  (
    <div className="Player">
      <video controls autoPlay>
        <source  type="video/mp4" />
      </video>
      <div className="Player-back">
        <button type="button" >
          Regresar
        </button>
      </div>
    </div>
  )
};

export default Player;