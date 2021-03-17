import React from 'react';
import { Helmet } from 'react-helmet';
import Products from '../components/Products';
import initialState from '../initialState';

const Home = () => {
  return (
    <>
      <Helmet>
        <title>Conf Merch</title>

        <meta name="twitter:card" content="summary_large_image" />
        <meta name="twitter:site" content="@NestorMonroy_" />
        <meta name="twitter:creator" content="@NestorMonroy_" />
        <meta name="twitter:title" content="Conf Store" />
        <meta name="twitter:description" content="Conf Store" />
        <meta
          name="twitter:image"
          content="https://s3.amazonaws.com/gndx.dev/gndxdev.png"
        />
        <meta property="og:title" content="Conf Store" />
        <meta property="og:description" content="Conf Store" />
        <meta
          property="og:image"
          content="https://s3.amazonaws.com/gndx.dev/gndxdev.png"
        />
        <meta property="og:url" content="store.xyz" />
        <meta property="og:site_name" content="Conf Store" />
        <meta property="og:locale" content="es_ES" />
        <meta property="og:type" content="article" />
        <meta property="fb:app_id" content="ID_APP_FACEBOOK" />
      </Helmet>
      <Products products={initialState.products} />
    </>
  );
}

export default Home;