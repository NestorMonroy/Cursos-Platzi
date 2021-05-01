import Navbar from '../components/Navbar/Navbar'
import react from 'react'

const Home = () => {
  const [ProductList, setProductList] = react.useState<TProduct[]>([])

  react.useEffect(() => {
    window
      .fetch('/api/avo')
      .then((res) => res.json())
      .then(({data, length}) => 
      setProductList(data))
  }, [])

  return (
    <div>
      <Navbar />
      <div>Hello! </div>
      {ProductList.map(product => (
        <div>{product.price}</div>
      ))}
    </div>
  )
}

export default Home
