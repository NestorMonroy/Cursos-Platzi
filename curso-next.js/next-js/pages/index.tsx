import React from "react";
import Layout from "@components/Layout/Layout";
import KawaiiHeader from "@components/KawaiiHeader/KawaiiHeader";
import ProductList from "@components/ProductList/ProductList";

const HomePage = () => {
  const [productList, setProductList] = React.useState<TProduct[]>([]);

  React.useEffect(() => {
    window
      .fetch("/api/avo")
      .then((response) => response.json())
      .then(({ data }: TAPIAvoResponse) => {
        setProductList(data);
      });
  }, []);

  return (
    <Layout>
      <KawaiiHeader />
      <ProductList products={productList} />
    </Layout>
  );
};

export default HomePage;
