import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { getVideoSource } from '../actions';
import '../assets/styles/components/Player.scss';
import NotFound from '../containers/NotFound';

const Player = props => {
  const { id } = props.match.params;

  return hasPlaying ? (
    <div className="Player">

      <div className="Player-back">

      </div>
    </div>
  ) : <NotFound />;
};



export default Player;