import { useRouter } from "next/router";

const ProductItem = () => {
  const {
    query: { productId },
  } = useRouter();
  return <div>Producto Item {productId} </div>;
};

export default ProductItem;
