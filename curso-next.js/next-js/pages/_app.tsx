import { AppProps } from 'next/app'
import Layout from '@components/Layout/Layout'

const MyApp = ({ Component, pageProps }: AppProps) => {
  // Providers - Context/Providers, theme , data 
  // Aditional props
  // Aditional layout
  // Manejar errores - componentDidCatch
  return (
    <Layout>
      <Component {...pageProps} />
    </Layout>
  )
}

export default MyApp
